package pl.jeleniagora.mks.dao.aux;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.stereotype.Component;

@Component
public class MyNamingStrategy implements PhysicalNamingStrategy {

	@Override
	public Identifier toPhysicalCatalogName(Identifier arg0, JdbcEnvironment arg1) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public Identifier toPhysicalColumnName(Identifier arg0, JdbcEnvironment arg1) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public Identifier toPhysicalSchemaName(Identifier arg0, JdbcEnvironment arg1) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public Identifier toPhysicalSequenceName(Identifier arg0, JdbcEnvironment arg1) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public Identifier toPhysicalTableName(Identifier arg0, JdbcEnvironment arg1) {
		// TODO Auto-generated method stub
		return arg0;
	}

}
