package rnd.op.jpa;

import rnd.dao.DataAccessObject;
import rnd.op.ObjectPersistor;

public interface JPAObjectPersistor extends ObjectPersistor {

	DataAccessObject getDataAccessObject();

}
