package ar.com.jalmeyda.dropwizardguice.dao;

import ar.com.jalmeyda.dropwizardguice.domain.Greeting;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by Juan Almeyda on 5/30/2016.
 */
@RegisterMapper (GreetingMapper.class)
public interface GreetingDao {

	@SqlUpdate ("create table greeting (id long primary key, name varchar(20))")
	void createTableIfNotExists();

	@SqlQuery ("select id, name from greeting where name = :name")
	List<Greeting> findGreetingByName(@Bind ("name") String name);

	@SqlUpdate ("insert into greeting (id, name) values (:id, :name)")
	void insert(@Bind ("id") Long id, @Bind ("name") String name);
}
