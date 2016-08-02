package ar.com.jalmeyda.dropwizardguice.domain;

import javax.validation.constraints.NotNull;

/**
 * Created by Juan Almeyda on 5/30/2016.
 */
public class HelloRequestBody {

    @NotNull
    String name;

    public String getName() {
        return name;
    }
}
