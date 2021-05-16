package es.upm.dit.isst.barriocovid.servlets;

import java.io.ByteArrayOutputStream;
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

import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.barriocovid.model.PEDIDO;


@WebServlet("/FormHacerPedido")
@MultipartConfig

public class FormHacerPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		
		   //id de la tabla == email_comprador
		   String email_c = req.getParameter("email_c");
		   System.out.println(email_c);
		   
		   //email_vendedor
		   String email_v =req.getParameter("item-vendedor");
		   System.out.println(email_v);
		   
		   //pdf productos
		   Part filePart = req.getPart("file");
	        InputStream fileContent = filePart.getInputStream();
			ByteArrayOutputStream output = new ByteArrayOutputStream();
	        byte[] buffer = new byte[1024];
	        for (int length = 0; (length = fileContent.read(buffer)) > 0;)
                 output.write(buffer, 0, length);
	     
	         
		   
		   //zona pedido
		   String zona =req.getParameter("zona");
		   System.out.println(zona);
		   
		   
		   //Crear un nuevo pedido
		   PEDIDO pedido = new PEDIDO();
		   
		   pedido.setComprador(email_c);
		   pedido.setVendedor(email_v);
		   
		   pedido.setProductos(output.toByteArray());
		   System.out.println(pedido.getProductos());
		   //estado 1 == pedido creado por cliente a falta de preparar
		   pedido.setStatus(1);
		   pedido.setZona(zona);
		   
		  
		   Client client = ClientBuilder.newClient(new ClientConfig());
		   
		   System.out.println("***************************");
			System.out.println("***   Creando Pedido   **");
			System.out.println("***************************");
			
			System.out.println("\n ");
			System.out.println("Servicio Rest: \n  " + URLHelper.getURL());
			System.out.println("\n");

		    
			
	
			Response r = client.target(URLHelper.getURL()).request()
						.post(Entity.entity(pedido, MediaType.APPLICATION_JSON), Response.class);
			
			
			
			
			System.out.println(r.getStatus());
			if (r.getStatus() == 201) {
				
				System.out.println("\n");
				System.out.println("Se ha creador un nuevo Pedido en la BBDD con exito!!!!! ");
				req.getSession().setAttribute("pedido", pedido);
				getServletContext().getRequestDispatcher("/PedidoConVendedor.jsp").forward(req, resp);
				return;
			}        
	        getServletContext().getRequestDispatcher("/index.html").forward(req, resp);

	}

}
