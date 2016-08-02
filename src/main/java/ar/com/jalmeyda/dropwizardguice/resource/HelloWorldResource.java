package ar.com.jalmeyda.dropwizardguice.resource;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by Juan Almeyda on 8/2/2016.
 */
@Path ("/hello")
public class HelloWorldResource {
	private final String message;

	@Inject
	public HelloWorldResource(@Named ("message") String message) {
		this.message = message;
	}

	@GET
	public String hello() {
		return message;
	}
}
