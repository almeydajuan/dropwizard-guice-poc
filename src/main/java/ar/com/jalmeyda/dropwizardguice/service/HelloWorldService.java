package ar.com.jalmeyda.dropwizardguice.service;

import ar.com.jalmeyda.dropwizardguice.dao.GreetingDao;
import ar.com.jalmeyda.dropwizardguice.domain.Greeting;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Juan Almeyda on 5/16/2016.
 */
@Singleton
public class HelloWorldService {

	private String template;
	private GreetingDao greetingDao;
	private final AtomicLong counter = new AtomicLong();

	@Inject
	public HelloWorldService(@Named ("template") String template, @Named ("greetingDao") GreetingDao greetingDao) {
		this.template = template;
		this.greetingDao = greetingDao;
	}

	public Greeting greetSomeone(String name) {
		final String value = String.format(template, name);
		Greeting greeting = new Greeting(counter.incrementAndGet(), value);
		greetingDao.insert(greeting.getId(), name);
		return greeting;
	}

	public Greeting getGreetingByName(String name) {
		Greeting greeting = greetingDao.findGreetingByName(name).get(0);
		greeting.setContent(String.format(template, greeting.getContent()));
		return greeting;
	}
}
