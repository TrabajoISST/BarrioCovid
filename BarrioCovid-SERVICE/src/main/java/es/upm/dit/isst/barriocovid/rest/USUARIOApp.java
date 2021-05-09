package es.upm.dit.isst.barriocovid.rest;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class USUARIOApp extends ResourceConfig{
	public USUARIOApp() {
		packages("es.upm.dit.isst.barriocovid.rest");
	}
}


