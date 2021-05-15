package es.upm.dit.isst.barriocovid.servlets;

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

import es.upm.dit.isst.barriocovid.model.PEDIDO;
import es.upm.dit.isst.barriocovid.servlets.URLHelper;

@WebServlet("/FormHacerPedido")
public class FormHacerPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			PEDIDO pedido = new PEDIDO();
			pedido.setComprador(req.getParameter("comprador"));
			pedido.setStatus(1);
			pedido.setVendedor(req.getParameter("vendedor"));
			//TODO Aniadir id del pedido
			Client client = ClientBuilder.newClient(new ClientConfig());
			Response r = client.target(URLHelper.getURL()).request()
						.post(Entity.entity(pedido, MediaType.APPLICATION_JSON), Response.class);
			if (r.getStatus() == 200) {
				req.getSession().setAttribute("pedido", pedido);
				getServletContext().getRequestDispatcher("/PEDIDO.jsp").forward(req, resp);
				return;
			}        
	        getServletContext().getRequestDispatcher("/index.html").forward(req, resp);

	}

}
