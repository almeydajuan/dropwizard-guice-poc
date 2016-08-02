package ar.com.jalmeyda.dropwizardguice.dao;

import ar.com.jalmeyda.dropwizardguice.domain.Greeting;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Juan Almeyda on 5/30/2016.
 */
public class GreetingMapper implements ResultSetMapper<Greeting> {

	@Override
	public Greeting map(int i, ResultSet resultSet, StatementContext statementContext)
			throws SQLException {
		Long id = resultSet.getLong("id");
		String name = resultSet.getString("name");
		return new Greeting(id, name);
	}
}
