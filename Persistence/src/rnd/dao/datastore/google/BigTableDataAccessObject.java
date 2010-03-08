package rnd.dao.datastore.google;

import rnd.dao.datastore.DataStoreDataAccessObject;
import rnd.dao.jdo.JDOQLDataAccessObject;
import rnd.dao.rdbms.JDOQLDAOContext;

public class BigTableDataAccessObject implements DataStoreDataAccessObject, JDOQLDataAccessObject {
	// , JPADataAccessObject {

	@Override
	public Object select(String[] fieldsNames, String from, String where, Object[] params, JDOQLDAOContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

}