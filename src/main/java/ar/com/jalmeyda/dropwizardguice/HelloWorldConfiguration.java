package ar.com.jalmeyda.dropwizardguice;

import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Juan Almeyda on 5/13/2016.
 */
public class HelloWorldConfiguration extends Configuration {

	@NotEmpty
	private String message;

	public String getMessage() {
		return message;
	}
}
