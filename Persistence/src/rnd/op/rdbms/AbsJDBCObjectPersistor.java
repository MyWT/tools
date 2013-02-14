package rnd.op.rdbms;

import rnd.dao.rdbms.jdbc.JDBCDataAccessObject;

public abstract class AbsJDBCObjectPersistor implements JDBCObjectPersistor {

	public JDBCDataAccessObject getDataAccessObject() {
		return new JDBCDataAccessObject();
	}

}
