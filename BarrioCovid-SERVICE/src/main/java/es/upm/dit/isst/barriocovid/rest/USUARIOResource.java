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

import org.hibernate.Session;

import es.upm.dit.isst.barriocovid.dao.SessionFactoryService;
import es.upm.dit.isst.barriocovid.dao.USUARIODAOImplementation;
import es.upm.dit.isst.barriocovid.model.USUARIO;

@Path("/USUARIOs")
public class USUARIOResource {
		//USUARIOs
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<USUARIO> readAllUSUARIO() {
			return USUARIODAOImplementation.getInstance().readAllUSUARIO();
		}
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response createUSUARIO(USUARIO unew) throws URISyntaxException {
			USUARIO u = USUARIODAOImplementation.getInstance().createUSUARIO(unew);
			if (u != null) {
				URI uri = new URI("/BarrioCovid-SERVICE/rest/USUARIOs/" + u.getEmail());
					return Response.created(uri).build();
		    }
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		//USUARIOs/id
		@GET
		@Path("{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response readUSUARIO(@PathParam("id") String id) {
			USUARIO u = USUARIODAOImplementation.getInstance().readUSUARIO(id);
			if (u == null)
				return Response.status(Response.Status.NOT_FOUND).build();
			return Response.ok(u, MediaType.APPLICATION_JSON).build();
		}
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("{id}")
		public Response updateUSUARIO(@PathParam("id") String id, USUARIO u) {
			System.out.println("Update request for" + id + " " + u.toString());
			USUARIO told = USUARIODAOImplementation.getInstance().readUSUARIO(id);
			if ((told == null) || (!
					told.getEmail().contentEquals(u.getEmail())))
				return Response.notModified().build();
			USUARIODAOImplementation.getInstance().updateUSUARIO(u); return Response.ok().build(); 
		}
		@DELETE
		@Path("{id}")
		public Response deleteUSUARIO(@PathParam("id") String id) {
			USUARIO rold = USUARIODAOImplementation.getInstance().readUSUARIO(id);
			if (rold == null)
				return Response.notModified().build();
			USUARIODAOImplementation.getInstance().deleteUSUARIO(rold);
			return Response.ok().build();
		}
		//USUARIOs/todosUsuarios/id
		@GET
		@Path("todosUsuarios")
		@Produces(MediaType.APPLICATION_JSON)
	    public int readAllUSUARIONumber() {
		    return USUARIODAOImplementation.getInstance().readAllUSUARIONumber();
	    }
		//USUARIOs/voluntario/id
		@GET
		@Path("voluntario/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public List<USUARIO> readAllUSUARIOVoluntario(@PathParam("id") String id) {
			return USUARIODAOImplementation.getInstance().readAllUSUARIOVoluntario(id);
		}
		//USUARIOs/vendedor/id
		@GET
		@Path("vendedor/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public List<USUARIO> readAllUSUARIOVendedor (@PathParam("id") String id) {
			return USUARIODAOImplementation.getInstance().readAllUSUARIOVendedor(id);
		}


}

