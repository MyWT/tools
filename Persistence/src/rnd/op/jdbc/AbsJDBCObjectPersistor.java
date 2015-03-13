package rnd.op.jdbc;

import rnd.dao.sql.jdbc.JDBCDataAccessObject;

public abstract class AbsJDBCObjectPersistor implements JDBCObjectPersistor {

	public JDBCDataAccessObject getDataAccessObject() {
		return new JDBCDataAccessObject();
	}

}
