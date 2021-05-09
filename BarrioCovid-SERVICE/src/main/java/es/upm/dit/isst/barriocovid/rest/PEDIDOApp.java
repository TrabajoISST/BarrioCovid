package es.upm.dit.isst.barriocovid.rest;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class PEDIDOApp extends ResourceConfig{
	public PEDIDOApp() {
		packages("es.upm.dit.isst.barriocovid.rest");
	}
}

