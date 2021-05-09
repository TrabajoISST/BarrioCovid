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
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.barriocovid.model.USUARIO;
import es.upm.dit.isst.barriocovid.servlets.URLHelperUSUARIO;


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
		int numeroUsuarios = -2;
		try {
			numeroUsuarios = Integer.parseInt(client.target(URLHelperUSUARIO.getURL() + "/todosUsuarios")
					.request().accept(MediaType.APPLICATION_JSON).toString());
		} catch(Exception e) {
			System.out.println("Ha habido un problema con el numero de usuarios");
			System.out.println(e);
		}
		usuario.setEmail(request.getParameter("email"));
		usuario.setPassword(request.getParameter("password"));
		usuario.setZona(request.getParameter("zona"));
		usuario.setDireccion(request.getParameter("direccion"));
		usuario.setRol(request.getParameter("rol"));
		usuario.setPedidosRealizados(Integer.parseInt(request.getParameter("pedidosRealizados")));
		usuario.setPedidosEntregados(Integer.parseInt(request.getParameter("pedidosEntregados")));
		usuario.setIdUsuario(numeroUsuarios + 1);
		Response r = client.target(URLHelperUSUARIO.getURL()).request()
				.post(Entity.entity(usuario, MediaType.APPLICATION_JSON), Response.class);
		System.out.println(r.getStatus());
		if ((r.getStatus() == 200) || (r.getStatus() == 201)) {
			request.getSession().setAttribute("usuario", usuario);
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
			return;
		}
		getServletContext().getRequestDispatcher("/error.html").forward(request, response);
	}


}
