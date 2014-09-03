package rnd.op;

import rnd.dao.DataAccessObject;

public abstract class AbsObjectPersitor implements ObjectPersistor {

	@Override
	public DataAccessObject getDataAccessObject() {
		return null;
	}

}
