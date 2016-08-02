package ar.com.jalmeyda.dropwizardguice;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by Juan Almeyda on 5/13/2016.
 */
public class HelloWorldConfiguration extends Configuration {

	@NotEmpty
	private String template;

	public String getTemplate() {
		return template;
	}

	@Valid
	@NotNull
	private DataSourceFactory database = new DataSourceFactory();

	@JsonProperty ("database")
	public void setDataSourceFactory(DataSourceFactory factory) {
		this.database = factory;
	}

	@JsonProperty ("database")
	public DataSourceFactory getDataSourceFactory() {
		return database;
	}
}
