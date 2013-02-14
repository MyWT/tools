package rnd.op.jpa;

import rnd.dao.jpa.JPADataAccessObject;
import rnd.op.ObjectPersistor;

public interface JPAObjectPersistor extends ObjectPersistor {
	
	JPADataAccessObject getDataAccessObject();

}
