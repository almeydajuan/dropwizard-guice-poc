package ar.com.jalmeyda.dropwizardguice.module;

import ar.com.jalmeyda.dropwizardguice.HelloWorldConfiguration;
import ar.com.jalmeyda.dropwizardguice.dao.GreetingDao;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

/**
 * Created by Juan Almeyda on 8/2/2016.
 */
public class HelloWorldModule extends AbstractModule {

	@Override
	protected void configure() {
	}

	@Provides
	@Named ("template")
	public String provideTemplate(HelloWorldConfiguration serverConfiguration) {
		return serverConfiguration.getTemplate();
	}

	@Provides
	@Named ("greetingDao")
	public GreetingDao provideGreetingDao(HelloWorldConfiguration serverConfiguration, Environment environment) {
		DBI dbi = new DBIFactory().build(environment, serverConfiguration.getDataSourceFactory(), "juan");
		GreetingDao greetingDao = dbi.onDemand(GreetingDao.class);
		greetingDao.createTableIfNotExists();
		return greetingDao;
	}
}
