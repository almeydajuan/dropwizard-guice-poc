package ar.com.jalmeyda.dropwizardguice;

import ar.com.jalmeyda.dropwizardguice.module.HelloWorldModule;
import ar.com.jalmeyda.dropwizardguice.resource.HelloWorldResource;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by Juan Almeyda on 5/13/2016.
 */
public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    private GuiceBundle<HelloWorldConfiguration> guiceBundle;

    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard-guice-poc";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        guiceBundle = GuiceBundle.<HelloWorldConfiguration>newBuilder()
                .addModule(new HelloWorldModule())
                .setConfigClass(HelloWorldConfiguration.class)
                .enableAutoConfig(getClass().getPackage().getName())
                .build();

        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) {
        environment.jersey().register(HelloWorldResource.class);
    }
}
