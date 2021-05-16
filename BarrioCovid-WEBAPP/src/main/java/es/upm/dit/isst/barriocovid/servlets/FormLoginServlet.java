package es.upm.dit.isst.barriocovid.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import es.upm.dit.isst.barriocovid.security.hashPassword;
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

import es.upm.dit.isst.barriocovid.model.PEDIDO;
import es.upm.dit.isst.barriocovid.model.USUARIO;

/**
 * Servlet implementation class FormLoginServlet
 */
@WebServlet("/FormLoginServlet")
public class FormLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormLoginServlet() {
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
		String email = request.getParameter("email");
		//String contrasena = request.getParameter("contrasena");
		String password1 = request.getParameter("contrasena");
		String password2 = hashPassword.getSHA512(password1);
		
		Client client = ClientBuilder.newClient(new ClientConfig());

		System.out.println("Antes de que se devuelva el user");
		USUARIO usuario = client.target(URLHelperUSUARIO.getURL() + "/" + email).request()
				.accept(MediaType.APPLICATION_JSON).get(new GenericType<USUARIO>() {
				});
		
	
		
		System.out.println(usuario);
		
		if(usuario.getRol().equals("vendedor") && (usuario.getPassword().contentEquals(password2))) {
			USUARIO usuario_v = usuario;
			request.setAttribute("i", usuario_v);
			
			List<PEDIDO> lista_p1 = client.target(URLHelper.getURL() + "/statusPedido/" + 1)
	                .request().accept(MediaType.APPLICATION_JSON)
	                .get(new GenericType<List<PEDIDO>>() {}
	                	);

				List<PEDIDO> pedidos_aPreparar = new ArrayList<PEDIDO>();
				if(lista_p1.size() > 0 ) {
					for(int  i  =0 ; i< lista_p1.size(); i++) {
						if( lista_p1.get(i).getStatus() == 1) {
							System.out.println(lista_p1.get(i));
							pedidos_aPreparar.add(lista_p1.get(i));
							}
						}
					request.setAttribute("pedidos_aPreparar", pedidos_aPreparar);
}
			getServletContext().getRequestDispatcher("/vendedor.jsp").forward(request, response);
			return;
		}
		
		else if(usuario.getRol().equals("comprador") && (usuario.getPassword().contentEquals(password2))) {
			
			USUARIO usuario_c = usuario;
			String zona = usuario.getZona();
			
			System.out.println("\n");
			System.out.println(URLHelperUSUARIO.getURL()+"/zona/" + zona);
			System.out.println("\n");
			//Traer solo vendedores en la zona del comprador....
			List<USUARIO> lista_u = client.target(URLHelperUSUARIO.getURL()+"/zona/" + zona)
					.request().accept(MediaType.APPLICATION_JSON)
					.get(new GenericType<List<USUARIO>>() {
					});
			
			System.out.println("\n");
			System.out.println(lista_u.size());
			System.out.println("\n");
			
			List<USUARIO> res_v = new ArrayList<USUARIO>();
		
			if (lista_u.size() > 0) {
				for (int i = 0; i < lista_u.size(); i++) {
					// System.out.println(lista_v.get(i).getRol());
					if ( lista_u.get(i).getRol().equals("vendedor")) {
						System.out.println(lista_u.get(i));
						res_v.add(lista_u.get(i));
					}
				}
				request.setAttribute("vendedores_enZona", res_v);

			}
			
			
			
			
			
			getServletContext().getRequestDispatcher("/comprador.jsp").forward(request, response);
			return;
		}
		else if(usuario.getRol().equals("voluntario")&& (usuario.getPassword().contentEquals(password2))){
			USUARIO usuario_v = usuario;

			System.out.println("\n");
			System.out.println("********************************");
			System.out.println("***   Pedidos con estado 3  **");
			System.out.println("********************************");
			System.out.println("\n");

		List<PEDIDO> lista_p3 = client.target(URLHelper.getURL() + "/statusPedido/" + 3).request()
				.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<PEDIDO>>() {
				});
		List<PEDIDO> pedido_voluntario_estado_3 = new ArrayList<PEDIDO>();
		System.out.println(usuario_v.getEmail());
		System.out.println(lista_p3);
		
		if (lista_p3.size() > 0) {
			System.out.println(lista_p3.size());

			for (int i = 0; i < lista_p3.size(); i++) {
				if(lista_p3.get(i).getVoluntario() != null) {
				System.out.println(lista_p3.get(i).getVoluntario());
				// Lista de pedidos asociada al voluntario con estado 3
				if (lista_p3.get(i).getVoluntario().equals(usuario_v.getEmail())) {
					System.out.println(lista_p3.get(i).getVoluntario());
					pedido_voluntario_estado_3.add(lista_p3.get(i));
				}
			}}
			System.out.println(pedido_voluntario_estado_3);
			request.setAttribute("pedido_voluntario_estado_3", pedido_voluntario_estado_3);
		}
		
		getServletContext().getRequestDispatcher("/voluntario.jsp").forward(request, response);
		return;
		}
		else {
			System.out.println("Se ha equivocado al introducir los credenciales, intente de nuevo");
		}
	}
}
