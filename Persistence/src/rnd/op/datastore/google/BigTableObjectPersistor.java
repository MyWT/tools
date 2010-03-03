package rnd.op.datastore.google;

import javax.jdo.PersistenceManagerFactory;

import rnd.op.datastore.DataStoreObjectPersistor;
import rnd.op.jdo.JDOPersistor;
import rnd.op.jdo.JDOPersistorImpl;
import rnd.op.rdbms.jpa.JPAObjectPersistor;

public class BigTableObjectPersistor extends JDOPersistorImpl implements DataStoreObjectPersistor, JDOPersistor, JPAObjectPersistor {

	public BigTableObjectPersistor(PersistenceManagerFactory pmf) {
		super(pmf);
	}

	@Override
	public String getInverseOwner(Class elementType, String indexedPrpName) {
		// TODO Auto-generated method stub
		return null;
	}

}
