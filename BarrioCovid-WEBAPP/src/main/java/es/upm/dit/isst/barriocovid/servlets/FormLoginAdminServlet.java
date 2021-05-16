package es.upm.dit.isst.barriocovid.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

/**
 * Servlet implementation class FormLoginAdminServlet
 */
@WebServlet("/FormLoginAdminServlet")
public class FormLoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String ADMIN_EMAIL = "root";
	private final String ADMIN_PASSWORD = "root"; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Client client = ClientBuilder.newClient(new ClientConfig());
		
		// autenticacion1 como ADMIN
		if( ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password) ) { 
			request.getSession().setAttribute("admin", true);
			getServletContext().getRequestDispatcher("/admin.jsp").forward(request,response);
			return;
		}
	}

}
