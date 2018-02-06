package testing.arancia.it;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/risorse")
public class ServiziR {
	
	@GET
	@Path("/testo")
	@Produces(MediaType.TEXT_PLAIN)
	public String getString(){
		return "servizio jax-rs";
	}

}
