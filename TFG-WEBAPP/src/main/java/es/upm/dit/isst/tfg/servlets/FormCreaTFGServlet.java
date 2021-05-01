package es.upm.dit.isst.tfg.servlets;

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

import es.upm.dit.isst.tfg.model.TFG;

@WebServlet("/FormCreaTFGServlet")
public class FormCreaTFGServlet extends HttpServlet {
//FALTA POR IMPLEMENTAR --> UTIL PARA EL BOTON DE REGISTRA UN REGISTRO EN LA BBDD
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String advisorEmail = req.getParameter("profesor");
		
		System.out.println(advisorEmail.indexOf("upm.es"));

		if (advisorEmail.indexOf("upm.es") > 0) {
			
			System.out.println("Repite TFG ojo está aquí");

			TFG tfg = new TFG();

			tfg.setEmail(req.getParameter("email"));

			tfg.setMark(-1.0);

			tfg.setStatus(1);
			tfg.setName(req.getParameter("name"));
			tfg.setTitle(req.getParameter("titulo"));
			tfg.setAdvisor(advisorEmail);

			Client client = ClientBuilder.newClient(new ClientConfig());

			System.out.println(URLHelper.getURL()); 
			Response r = client.target(URLHelper.getURL()).request()

					.post(Entity.entity(tfg, MediaType.APPLICATION_JSON)

							, Response.class);

			//Para la primera vez que se registra devuelve codigo 201
			System.out.println(r.getStatus());
			if (r.getStatus() == 200) {
				req.getSession().setAttribute("tfg", tfg);
				getServletContext().getRequestDispatcher("/TFG.jsp")
						.forward(req, resp);

				return;

			}
			
//			if (r.getStatus() == 201) {
//				req.getSession().setAttribute("tfg", tfg);
//				getServletContext().getRequestDispatcher("/TFG.jsp")
//						.forward(req, resp);
//
//				return;
//
//			}
			
			

		}
		
		
		
		// En el caso de que no escriba bien el correo se manda al index.html
		getServletContext().getRequestDispatcher("/index.html").forward(req, resp);

	}
	
	
	
}
