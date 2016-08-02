package ar.com.jalmeyda.dropwizardguice.resource;

import ar.com.jalmeyda.dropwizardguice.domain.Greeting;
import ar.com.jalmeyda.dropwizardguice.domain.HelloRequestBody;
import ar.com.jalmeyda.dropwizardguice.service.HelloWorldService;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Juan Almeyda on 8/2/2016.
 */
@Path ("/hello")
@Consumes (MediaType.APPLICATION_JSON)
@Produces (MediaType.APPLICATION_JSON)
public class HelloWorldResource {

	private final String template;
	private final HelloWorldService helloWorldService;
	private final AtomicLong counter = new AtomicLong();

	@Inject
	public HelloWorldResource(@Named ("template") String template, HelloWorldService helloWorldService) {
		this.template = template;
		this.helloWorldService = helloWorldService;
	}

	@GET
	@Timed
	public Greeting getGreeting(@QueryParam ("name") String name) {
		return helloWorldService.getGreetingByName(name);
	}

	@POST
	@Timed
	public Greeting greetSomeone(@Valid HelloRequestBody helloRequestBody) {
		return helloWorldService.greetSomeone(helloRequestBody.getName());
	}
}
