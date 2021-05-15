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

/**
 * Servlet implementation class FormSubeMemoriaServlet
 */
@WebServlet("/FormSubeMemoriaServlet")
@MultipartConfig
public class FormSubirPedido extends HttpServlet {
  private static final long serialVersionUID = 1L;
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
               throws ServletException, IOException {
    // autorizacion, comprobar
    String comprador = req.getParameter("comprador");
    Client client = ClientBuilder.newClient(new ClientConfig());
    PEDIDO pedido = null;
    try {
         pedido = client.target(URLHelper.getURL() + "/" + comprador)
           .request().accept(MediaType.APPLICATION_JSON).get(PEDIDO.class);
    } catch(Exception e) {}
    // autorizacion
    if ((pedido != null) && (pedido.getStatus() == 3)) {
         Part filePart = req.getPart("file");
         InputStream fileContent = filePart.getInputStream();
         ByteArrayOutputStream output = new ByteArrayOutputStream();
         byte[] buffer = new byte[1024];
         for (int length = 0; (length = fileContent.read(buffer)) > 0;)
                 output.write(buffer, 0, length);
         //pedido.setDocument(output.toByteArray());
         //TODO aniadir este paramtro a la entidad para subir un documento
         pedido.setStatus(4);
        client.target(URLHelper.getURL() + "/" + pedido.getComprador()).request()
                 .post(Entity.entity(pedido, MediaType.APPLICATION_JSON), Response.class);
         req.setAttribute("pedido", pedido);
     }
    getServletContext().getRequestDispatcher("/PEDIDO.jsp").forward(req,resp);
  }
}
