package rnd.op.dnap;

import javax.jdo.PersistenceManagerFactory;

import rnd.op.jdo.AbsJDOPersistor;

public class DNAPJDObjectPersistor extends AbsJDOPersistor {

	public DNAPJDObjectPersistor() {
		// FIXME Java bug
		// PersistenceManagerFactory pmf =
		// JDOHelper.getPersistenceManagerFactory(getClass().getClassLoader().getResourceAsStream("pmf.properties"));
		// super(pmf);
		super(null);
	}

	public DNAPJDObjectPersistor(PersistenceManagerFactory pmf) {
		super(pmf);
	}

}