package es.upm.dit.isst.barriocovid.servlets;

import java.io.IOException;import javax.servlet.ServletException;
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
import es.upm.dit.isst.barriocovid.model.USUARIO;


/**
 * Servlet implementation class ConfirmarPedidoServlet
 */
@WebServlet("/ConfirmarPedidoServlet")
public class ConfirmarPedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfirmarPedidoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email_c = request.getParameter("email_c");
			
		USUARIO usuario = null;

		Client client = ClientBuilder.newClient(new ClientConfig());

		PEDIDO pedido = null;
		
		
		try {

			
			System.out.println("\n ");
			System.out.println("Servicio Rest: \n  " + URLHelper.getURL() + "/" + email_c);
			System.out.println("\n");
			

			// Peticion Rest ==> devolver toda pedido asociado al email_c
			pedido = client.target(URLHelper.getURL() + "/" + email_c).request().accept(MediaType.APPLICATION_JSON)
					.get(PEDIDO.class);
		} catch (Exception e) {
		}
		usuario = client.target(URLHelperUSUARIO.getURL() + "/" + pedido.getVoluntario()).request().accept(MediaType.APPLICATION_JSON).get(USUARIO.class);
		
		System.out.println(pedido);
		System.out.println(usuario);
		
		if(usuario!= null) {
			
			usuario.setPedidosRealizados(1);
			usuario.setPedidosEntregados(1);
			
			client.target(URLHelperUSUARIO.getURL() + "/" + usuario.getEmail())
			.request().post(Entity.entity(usuario, MediaType.APPLICATION_JSON), Response.class);

		}
		if(pedido!=null) {
		pedido.setStatus(4);
		
		
		System.out.println("\n");
		System.out.println("Actualizando pedido en la BBDD....");
		System.out.println("\n");

		client.target(URLHelper.getURL() + "/" + email_c)
		.request().post(Entity.entity(pedido, MediaType.APPLICATION_JSON), Response.class);

	}

	request.setAttribute("pedido",pedido);
	getServletContext().getRequestDispatcher("/PedidosConfirmados.jsp").forward(request, response);
	}

}
