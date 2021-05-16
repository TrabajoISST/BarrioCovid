package es.upm.dit.isst.barriocovid.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.barriocovid.model.PEDIDO;

/**
 * Servlet implementation class FinPedidoServlet
 */
@WebServlet("/FinPedidoServlet")
public class FinPedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public FinPedidoServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//id de la tabla == email_comprador
		String email_c = request.getParameter("email_c");
		System.out.println(email_c);
		
		
		//email_voluntario
		
		String email_v =request.getParameter("voluntario");
		System.out.println(email_v);
		
		Client client = ClientBuilder.newClient(new ClientConfig());
		
		PEDIDO pedido = null;
		
		try {
			
			System.out.println("\n ");
			System.out.println("Servicio Rest: \n  " + URLHelper.getURL() + "/" + email_c);
			System.out.println("\n");
			
			//Peticion Rest  ==> devolver toda pedido asociado al email_c
			pedido = client.target(URLHelper.getURL() + "/" + email_c)
					.request().accept(MediaType.APPLICATION_JSON).get(PEDIDO.class);

	
		} catch (Exception e) {
			
			
		}
		
		if( pedido != null) {
			
			pedido.setVoluntario(email_v);
			pedido.setStatus(3);
			
			System.out.println("\n");
			System.out.println("Actualizando pedido en la BBDD....");
			System.out.println("\n");
			client.target(URLHelper.getURL() + "/" + email_c)
			.request()
			.post(Entity.entity(pedido, MediaType.APPLICATION_JSON), Response.class);
			
			

		}
		
		request.setAttribute("pedido", pedido);
		
		getServletContext().getRequestDispatcher("/PedidosConfirmados.jsp")
		.forward(request, response);
		
		
	}

	

}
