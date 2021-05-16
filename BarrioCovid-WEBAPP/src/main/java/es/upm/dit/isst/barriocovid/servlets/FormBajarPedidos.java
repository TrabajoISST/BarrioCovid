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
import es.upm.dit.isst.barriocovid.servlets.URLHelper;


/**
 * Servlet implementation class FormBajarPedidos
 */
@WebServlet("/FormBajarPedidos")
public class FormBajarPedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormBajarPedidos() {
        super();
        // TODO Auto-generated constructor stub
    }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email_c = request.getParameter("email_c");
		 Client client = ClientBuilder.newClient(new ClientConfig());
		 
		 System.out.println(email_c);
		 
		 PEDIDO pedido = null;
		 
		 try {   pedido = client.target(URLHelper.getURL()+"/"+ email_c)
			      .request().accept(MediaType.APPLICATION_JSON).get(PEDIDO.class);
			  }catch(Exception e) {}
		 
		 pedido.setStatus(2);
		 
		 Response r = client.target(URLHelper.getURL() + "/" + email_c).request()
                 .post(Entity.entity(pedido, MediaType.APPLICATION_JSON), Response.class);
		 System.out.println("Su status se ha actualizado " + pedido.getStatus());
		 
		 if (r.getStatus() == 201) {
             request.getSession().setAttribute("pedido_aPreparar", pedido);
             getServletContext().getRequestDispatcher("/pedidoPreparado.jsp").forward(request, response);
             return;



         }
		 
		 System.out.println(pedido);
		 System.out.println(pedido.getProductos());
		 if((pedido!= null) && (pedido.getProductos() != null)){
			 response.setContentType("application/pdf");
			 response.setHeader("Content-Disposition"
			          , String.format("attachment; filename=\"%s\"", "pedidos.pdf"));
			    response.setContentLength(pedido.getProductos().length);
			    response.getOutputStream().write(pedido.getProductos());
		 }

	}

}
