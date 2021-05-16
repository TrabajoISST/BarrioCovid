package es.upm.dit.isst.barriocovid.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.barriocovid.model.USUARIO;
import es.upm.dit.isst.barriocovid.servlets.URLHelperUSUARIO;

@WebServlet("/FormDescargarPDFProductos")
public class FormDescargarPDFProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public FormDescargarPDFProductos() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email_v = request.getParameter("email_v");
		 Client client = ClientBuilder.newClient(new ClientConfig());
		 
		 System.out.println(email_v);
		 
		 USUARIO usuario = null;
		 
		 try {   usuario = client.target(URLHelperUSUARIO.getURL()+"/"+ email_v)
			      .request().accept(MediaType.APPLICATION_JSON).get(USUARIO.class);
			  }catch(Exception e) {}
		 
		 System.out.println(usuario);
		 System.out.println(usuario.getProductos());
		 if((usuario!= null) && (usuario.getProductos() != null)){
			 response.setContentType("application/pdf");
			 response.setHeader("Content-Disposition"
			          , String.format("attachment; filename=\"%s\"", "productos.pdf"));
			    response.setContentLength(usuario.getProductos().length);
			    response.getOutputStream().write(usuario.getProductos());
		 }

	}

}
