package es.upm.dit.isst.barriocovid.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import java.io.ByteArrayOutputStream;


import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.barriocovid.model.USUARIO;
import es.upm.dit.isst.barriocovid.servlets.URLHelperUSUARIO;


/**
 * Servlet implementation class FormSubirPDFProductos
 */
@WebServlet("/FormSubirPDFProductos")
@MultipartConfig

public class FormSubirPDFProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FormSubirPDFProductos() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email_v = request.getParameter("email_v");
		Client client = ClientBuilder.newClient(new ClientConfig());
		USUARIO usuario = null;
		 System.out.println(email_v);
		try {
		 usuario = client.target(URLHelperUSUARIO.getURL()+ "/" + email_v)
					 .request().accept(MediaType.APPLICATION_JSON).get(USUARIO.class);
		} catch(Exception e) {}
		 System.out.println(usuario);
		 
		 
		if (usuario != null) {
			 Part filePart = request.getPart("file");
			 System.out.println(filePart);
	         InputStream fileContent = filePart.getInputStream();
			 System.out.println(fileContent);
	         ByteArrayOutputStream output = new ByteArrayOutputStream();
			 System.out.println(output);
	         byte[] buffer = new byte[1024];
			 System.out.println(buffer);
	         for (int length = 0; (length = fileContent.read(buffer)) > 0;)
                 output.write(buffer, 0, length);
			 System.out.println(output.toByteArray());
	         usuario.setProductos(output.toByteArray());
			 System.out.println(usuario.getProductos());
	         
	         //actualizando PDF en el registro de vendedor
	         
	         client.target(URLHelperUSUARIO.getURL() + "/" + usuario.getEmail()).request()
             .post(Entity.entity(usuario, MediaType.APPLICATION_JSON), Response.class);
	         request.setAttribute("i", usuario);
		}
	         getServletContext().getRequestDispatcher("/PDFSubido.jsp").forward(request,response);

		 
	}

}
