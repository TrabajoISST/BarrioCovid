package es.upm.dit.isst.barriocovid.servlets;

import java.io.IOException;//import java.util.List;
import es.upm.dit.isst.barriocovid.security.hashPassword;
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

import es.upm.dit.isst.barriocovid.model.USUARIO;



/**
 * Servlet implementation class FormRegistroUsuarioServlet
 */
@WebServlet("/FormRegistroUsuarioServlet")
public class FormRegistroUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Client client = ClientBuilder.newClient(new ClientConfig());
		USUARIO usuario = new USUARIO();
		String password1 = request.getParameter("password");

		String password2 = hashPassword.getSHA512(password1);
		usuario.setEmail(request.getParameter("email"));
		usuario.setPassword(password2);
		usuario.setZona(request.getParameter("zona"));
		usuario.setDireccion(request.getParameter("direccion"));
		usuario.setRol(request.getParameter("rol"));
		usuario.setPedidosRealizados(Integer.parseInt(request.getParameter("pedidosRealizados")));
		usuario.setPedidosEntregados(Integer.parseInt(request.getParameter("pedidosEntregados")));
		Response r = client.target(URLHelperUSUARIO.getURL()).request()
		.post(Entity.entity(usuario, MediaType.APPLICATION_JSON), Response.class);
		System.out.println(r.getStatus());
		if ((r.getStatus() == 200) || (r.getStatus() == 201)) {
		request.getSession().setAttribute("usuario", usuario);
		System.out.println("Se ha creado con éxito el perfil de " + usuario.getEmail());
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		return;
		}
		getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
	}


}
