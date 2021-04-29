package es.upm.dit.isst.barriocovid.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;

//import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;

//import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

import es.upm.dit.isst.barriocovid.dao.BarrioCovidDAOImplementation;
import es.upm.dit.isst.barriocovid.model.BarrioCovid;



/***************************************************************************************
 * 
 *                    * BarrioCovidResources *
 *    - Contiene funciones RESTful, que usará de metodos CRUD
 * 
 * **************************************************************************************/



@Path("/COVID")
public class BarrioCovidResource {
	

	
	/************************************************
	 * DEVUELVE TABLA COMPLETA ==>   BARRIOCOVID
	 ***********************************************/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<BarrioCovid> readAll() {
		/************  Hace uso del CRUD ==> .readAll() *********/
		return BarrioCovidDAOImplementation.getInstance().readAll();//Usa el CRUD: readAll()
		
	}
	
	
	/*****************************************************
	 * EN FUNCION DEL ID DEVUELVE  ==> "SUB-TABLA"
	 ****************************************************/
	
	
	//en funcion del email se obtendra una subtabla
	@GET
	@Path("usuario/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BarrioCovid> readAll (@PathParam("id") String id) {
		
		/************  Hace uso del CRUD ==> .readAll(String email) *********/
		return BarrioCovidDAOImplementation.getInstance().readAll(id);
	}
	

	
	/******************************************************
	 * LEE UN REGISTRO DE LA TABLA ==> BARRIOCOVID
	 ******************************************************/
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response read(@PathParam("id") String id) {

		/************  Hace uso del CRUD ==> .read() *********/
		BarrioCovid t = BarrioCovidDAOImplementation.getInstance().read(id);
		
		
		if (t == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		System.out.print("\n");
		System.out.print(id + " tiene asociado el siguiente pedido: " + t);
		System.out.print("\n");

		return Response.ok(t, MediaType.APPLICATION_JSON).build();

	}
	
	
	
	/******************************************************
	 * CREA UN NUEVO REGISTRO EN LA TABLA ==> BARRIOCOVID
	 ******************************************************/
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(BarrioCovid tnew) throws URISyntaxException {
		
		/************* Hace uso del CRUD ==> .create() **********/
		BarrioCovid t = BarrioCovidDAOImplementation.getInstance().create(tnew);
		
		if (t !=  null) {
			URI uri = new URI("/TFG-SERVICE/rest/TFGs/" + t.getEmail());
			return Response.created(uri).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	
	
	/******************************************************
	 * ACTUALIZAR UN REGISTRO DE LA TABLA ==> BARRIOCOVID
	 ******************************************************/
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response update(@PathParam("id") String id, BarrioCovid t) {

		System.out.println("Update request for" + id + " " + t.toString());

		BarrioCovid told = BarrioCovidDAOImplementation.getInstance().read(id);

		if ((told == null) || (!told.getEmail().contentEquals(t.getEmail())))

			return Response.notModified().build();

		BarrioCovidDAOImplementation.getInstance().update(t);

		return Response.ok().build();

	}
	
	
	
	/******************************************************
	 * ELIMINAR UN REGISTRO DE LA TABLA ==> BARRIOCOVID
	 ******************************************************/
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") String id) {

		BarrioCovid rold = BarrioCovidDAOImplementation.getInstance().read(id);

		if (rold == null)
			return Response.notModified().build();

		System.out.print("\n");
		BarrioCovidDAOImplementation.getInstance().delete(rold);
		System.out.print("Se ha eliminado el registro: " + rold);
		

		return Response.ok().build();

	}
	
	
	
	
	
	
	
	
	

}
