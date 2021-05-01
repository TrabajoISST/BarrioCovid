package es.upm.dit.isst.tfg.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;


import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.GenericType;


import org.glassfish.jersey.client.ClientConfig;


import es.upm.dit.isst.tfg.model.TFG;



@WebServlet("/FormLoginServlet")
public class FormLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final String ADMIN_EMAIL = "root";

	private final String ADMIN_PASSWORD = "root";

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)

			throws ServletException, IOException {
		

/*****************************************************************
		              * LOGIN ADMIN *
 *****************************************************************/		

		
		String email = req.getParameter("email");
        String password = req.getParameter("password");
		Client client = ClientBuilder.newClient(new ClientConfig());
		
		// String rol = req.getParameter("rol");

		System.out.println(email);
		//System.out.println(" \n TRAZA 1");
		// autenticacion1
		if (ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password)) {		
			System.out.println(" \n TRAZA 2");
			//guardar atributos que se añade a la sesion para controlar el acceso
			//a los recursos( autorizacion) 
			req.getSession().setAttribute("admin", true);

			//System.out.println(" \n TRAZA3");
			System.out.println(URLHelper.getURL());
			List<TFG> tfgs = client.target(URLHelper.getURL())
					.request().accept(MediaType.APPLICATION_JSON)
					.get(new GenericType<List<TFG>>() {});
			
			//System.out.println(" \n la lista" + tfgs);

			// pasando info transitorio al JSP
			req.setAttribute("tfgs", tfgs);

			//cargar la vista
			//escribir ruta del JSP
			getServletContext().getRequestDispatcher("/Admin.jsp")
					.forward(req, resp);

			return;
			
		}
		
		
/*****************************************************************
		            *   LOGIN PROFESOR    * 
****************************************************************** */		

		// autenticacion2
		
		//System.out.println(email.indexOf("@upm.es"));
		if (email.indexOf("@upm.es") > -1) {
			
			System.out.println("DENTRO DEL IF.....");
			
			//guardar informacion en la session 
			req.getSession().setAttribute("profesor", email);
			
			System.out.println(URLHelper.getURL()

					+ "/professor/" + email);

			List<TFG> tfgs = client.target(URLHelper.getURL()

					+ "/professor/" + email)

					.request().accept(MediaType.APPLICATION_JSON)

					.get(new GenericType<List<TFG>>() {
					});
			
			System.out.println(tfgs);

			// pasando info transitorio al JSP
			req.setAttribute("tfgs", tfgs);

			//cargar la vista
			//escribir ruta del JSP
			getServletContext().getRequestDispatcher("/Profesor.jsp")

					.forward(req, resp);

			return;

		}

/*****************************************************************
               *     LOGIN ALUMNO    *
 ****************************************************************** */
		// autenticacion3
		TFG tfg = null;

		try {
			tfg = client.target(URLHelper.getURL() + "/" + email)

					.request().accept(MediaType.APPLICATION_JSON).get(TFG.class);

		} catch (Exception e) {
			System.out.println("Imprimiendo el error...\n");
			System.out.println(e);

		}

		if (null != tfg) {

			//guardar informacion en la session 
			req.getSession().setAttribute("tfg", tfg);
			

			//cargar la vista
			//escribir ruta del JSP
			getServletContext().getRequestDispatcher("/TFG.jsp").forward(req, resp);

			return;

		}

		System.out.println("\n");
		
		
		System.out.println(email + " no encontrado en la BBDD");
		//cargar la vista
		//escribir ruta del JSP
		getServletContext().getRequestDispatcher("/index.html").forward(req, resp);

	}

}
