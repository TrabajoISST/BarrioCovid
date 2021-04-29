package es.upm.dit.isst.barriocovid.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;


@ApplicationPath("rest")
public class BarrioCovidApp extends ResourceConfig {

	public  BarrioCovidApp() {
		packages("es.upm.dit.isst.barriocovid.rest");
	}

}
