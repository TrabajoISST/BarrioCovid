package es.upm.dit.isst.barriocovid.servlets;

import java.io.IOException;
import java.util.ArrayList;
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

import es.upm.dit.isst.barriocovid.model.PEDIDO;
import es.upm.dit.isst.barriocovid.model.USUARIO;

/**
 * Servlet implementation class LoginAdminServlet
 */
@WebServlet("/LoginAdminServlet")
public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String ADMIN_EMAIL = "root";
	private final String ADMIN_PASSWORD = "root";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
	
		Client client  = ClientBuilder.newClient(new ClientConfig());
if (ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password)) {
			
			
			req.getSession().setAttribute("admin", true);
			System.out.println("***************************");
			System.out.println("***   Bienvenido Admin   **");
			System.out.println("***************************");
			System.out.println("\n");
			
			System.out.println("Servicio Rest:  \n "  + URLHelperUSUARIO.getURL());
			System.out.println("\n");
			System.out.println("Accediendo a la BBDD....");
			
			//Traerse toda la tabla USUARIO
			List<USUARIO> lista_final = client.target(URLHelperUSUARIO.getURL())
					.request().accept(MediaType.APPLICATION_JSON)
					.get(new GenericType<List<USUARIO>>() {
					});
			
			//System.out.println("\n");
			//System.out.println("Usuarios Actuales..... \n " + lista_final);
			//Esto es necesario para pintar los valores en el Admin.jsp
			
			req.setAttribute("lista_final", lista_final);
			
			
			System.out.println("\n");
			System.out.println("Servicio Rest:  \n "  + URLHelperUSUARIO.getURL()+"/numeroPedidos/"+ 0);
			System.out.println("\n");
			System.out.println("Accediendo a la BBDD....");
			
			//Traer solo voluntarios con 0 pedidos...
			List<USUARIO> lista_u = client.target(URLHelperUSUARIO.getURL()+"/numeroPedidos/"+ 0)
					.request().accept(MediaType.APPLICATION_JSON)
					.get(new GenericType<List<USUARIO>>() {
					});
			
			
			//solo voluntarios sin pedidos....
			List<USUARIO> res = new ArrayList<USUARIO>();
			
			
			if(lista_u.size() > 0 ) {
				
				for( int i=0; i < lista_u.size(); i++) {
					//System.out.println(lista_v.get(i).getRol());
					if(lista_u.get(i).getRol().equals("voluntario") && lista_u.get(i).getPedidosRealizados() == 0 ) {
						System.out.println(lista_u.get(i));
						res.add(lista_u.get(i));
						
					}
					
				}
				
				
				req.setAttribute("voluntarios_cero", res);
						
			}
			System.out.println("\n");
			System.out.println("********************************");
			System.out.println("***   Pedidos con estado 1   **");
			System.out.println("********************************");
			System.out.println("\n");
			

			List<PEDIDO> lista_p1 = client.target(URLHelper.getURL() + "/statusPedido/" + 1)
					                .request().accept(MediaType.APPLICATION_JSON)
					                .get(new GenericType<List<PEDIDO>>() {}
					                	);
			
			List<PEDIDO> pedidos_sinpreparar = new ArrayList<PEDIDO>();
			
	if(lista_p1.size() > 0 ) {
				
				for(int  i  =0 ; i< lista_p1.size(); i++) {
					if( lista_p1.get(i).getStatus() == 1) {
						System.out.println(lista_p1.get(i));
						pedidos_sinpreparar.add(lista_p1.get(i));
						}
					}
					req.setAttribute("p_sinpreparar", pedidos_sinpreparar);
				}
			
			
			//pedidos preparados por vendedor estado 2
			System.out.println("\n");
			System.out.println("********************************");
			System.out.println("***   Pedidos con estado 2   **");
			System.out.println("********************************");
			System.out.println("\n");
			
			List<PEDIDO> lista_p2 = client.target(URLHelper.getURL() + "/statusPedido/" + 2)
					                .request().accept(MediaType.APPLICATION_JSON)
					                .get(new GenericType<List<PEDIDO>>() {}
					                	);
			
			
			//System.out.println(lista_p2);
			//solo voluntarios sin pedidos....
			List<PEDIDO> pedidos_preparados = new ArrayList<PEDIDO>();
			
			//List<PEDIDO> pedidos_confirmados = new ArrayList<PEDIDO>();
			if(lista_p2.size() > 0 ) {
				
				for(int  i  =0 ; i< lista_p2.size(); i++) {
					
					if( lista_p2.get(i).getStatus() == 2) {
						
						System.out.println(lista_p2.get(i));
						pedidos_preparados.add(lista_p2.get(i));
						
					}
				
				}
				
				req.setAttribute("pedidos_preparados", pedidos_preparados);
			}
			
			
			System.out.println("\n");
			System.out.println("********************************");
			System.out.println("***   Pedidos con estado 3  **");
			System.out.println("********************************");
			System.out.println("\n");
			
			List<PEDIDO> lista_p3 = client.target(URLHelper.getURL() + "/statusPedido/" + 3).request()
					.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<PEDIDO>>() {
					});

             //System.out.println(lista_p3);
			//pedidos finales....

			List<PEDIDO> p_sinConfirmar = new ArrayList<PEDIDO>();
			if (lista_p3.size() > 0) {

				for (int i = 0; i < lista_p3.size(); i++) {

					if (lista_p3.get(i).getStatus() == 3) {

						p_sinConfirmar.add(lista_p3.get(i));
					}

				}

				req.setAttribute("p_sinConfirmar", p_sinConfirmar);

			}				           
			
			System.out.println("\n");
			System.out.println("********************************");
			System.out.println("***   Pedidos con estado 4  **");
			System.out.println("********************************");
			System.out.println("\n");
			
			List<PEDIDO> lista_p4 = client.target(URLHelper.getURL() + "/statusPedido/" + 4).request()
					.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<PEDIDO>>() {
					});

             //System.out.println(lista_p3);
			//pedidos finales....

			List<PEDIDO> pedidos_confirmados_fin = new ArrayList<PEDIDO>();
			if (lista_p4.size() > 0) {

				for (int i = 0; i < lista_p4.size(); i++) {

					if (lista_p4.get(i).getStatus() == 4) {

						pedidos_confirmados_fin.add(lista_p4.get(i));
					}

				}

				req.setAttribute("p_confirmados_fin", pedidos_confirmados_fin);

			}
			
			
		
			getServletContext().getRequestDispatcher("/Admin.jsp")
			.forward(req, resp);
			
			return;
		} 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
