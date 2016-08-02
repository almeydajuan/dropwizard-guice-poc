package ar.com.jalmeyda.dropwizardguice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * Created by Juan Almeyda on 8/2/2016.
 */
public class Greeting {

	private Long id;

	@Length (max = 20)
	private String content;

	public Greeting() {
		// Jackson deserialization
	}

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	@JsonProperty
	public Long getId() {
		return id;
	}

	@JsonProperty
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
