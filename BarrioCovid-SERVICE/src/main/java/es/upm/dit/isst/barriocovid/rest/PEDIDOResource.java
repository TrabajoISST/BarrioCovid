package es.upm.dit.isst.barriocovid.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.upm.dit.isst.barriocovid.dao.PEDIDODAOImplementation;
import es.upm.dit.isst.barriocovid.model.PEDIDO;


@Path("/PEDIDOs")
public class PEDIDOResource {
		//PEDIDOs
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<PEDIDO> readAll () {
			return PEDIDODAOImplementation.getInstance().readAll();
		}
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response create(PEDIDO pnew) throws URISyntaxException {
			PEDIDO p = PEDIDODAOImplementation.getInstance().create(pnew);
			if (p != null) {
				URI uri = new URI("/BarrioCovid-SERVICE/rest/PEDIDOs/" + p.getComprador());
					return Response.created(uri).build();
		    }
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		//PEDIDOs/id
		@GET
		@Path("{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response read(@PathParam("id") String id) {
			PEDIDO p = PEDIDODAOImplementation.getInstance().read(id);
			if (p == null)
				return Response.status(Response.Status.NOT_FOUND).build();
			return Response.ok(p, MediaType.APPLICATION_JSON).build();
		}
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("{id}")
		public Response update(@PathParam("id") String id, PEDIDO p) {
			System.out.println("Update request for" + id + " " +
					p.toString());
			PEDIDO told = PEDIDODAOImplementation.getInstance().read(id);
			if ((told == null) || (!
					told.getComprador().contentEquals(p.getComprador())))
				return Response.notModified().build();
			PEDIDODAOImplementation.getInstance().update(p); return Response.ok().build(); 
		}
		@DELETE
		@Path("{id}")
		public Response delete(@PathParam("id") String id) {
			PEDIDO rold = PEDIDODAOImplementation.getInstance().read(id);
			if (rold == null)
				return Response.notModified().build();
			PEDIDODAOImplementation.getInstance().delete(rold);
			return Response.ok().build();
		}
		//PEDIDOs/vendedor/id
		@GET
		@Path("vendedor/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public List<PEDIDO> readAllVendedor (@PathParam("id") String id) {
			return PEDIDODAOImplementation.getInstance().readAllVendedor(id);
		}
		//PEDIDOs/voluntario/id
		@GET
		@Path("voluntario/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public List<PEDIDO> readAllVoluntario (@PathParam("id") String id) {
			return PEDIDODAOImplementation.getInstance().readAllVoluntario(id);
		}


}

