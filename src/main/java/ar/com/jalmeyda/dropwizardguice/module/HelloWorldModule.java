package ar.com.jalmeyda.dropwizardguice.module;

import ar.com.jalmeyda.dropwizardguice.HelloWorldConfiguration;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;

/**
 * Created by Juan Almeyda on 8/2/2016.
 */
public class HelloWorldModule extends AbstractModule {

	@Override
	protected void configure() {
	}

	@Provides
	@Named ("message")
	public String provideMessage(HelloWorldConfiguration serverConfiguration) {
		return serverConfiguration.getMessage();
	}
}
