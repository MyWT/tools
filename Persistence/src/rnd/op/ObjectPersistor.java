package rnd.op;

import rnd.dao.DataAccessObject;

public interface ObjectPersistor extends ObjectLifeCycleSupport {

	// Object getObjectId(Object object);

	<DAO extends DataAccessObject> DAO getDataAccessObject();

}