package rnd.op.dnap;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import rnd.op.jdo.JDOPersistor;
import rnd.op.jdo.JDOPersistorDelegate;

public class DNAPJDObjectPersistor implements JDOPersistor {

	private final JDOPersistorDelegate delegate;

	public DNAPJDObjectPersistor() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(getClass().getClassLoader().getResourceAsStream("pmf.properties"));
		delegate = new JDOPersistorDelegate(pmf);
	}

	public DNAPJDObjectPersistor(PersistenceManagerFactory pmf) {
		delegate = new JDOPersistorDelegate(pmf);
	}

	@Override
	public String getInverseOwner(Class elementType, String indexedPrpName) {
		return delegate.getInverseOwner(elementType, indexedPrpName);
	}

	@Override
	public Object createObjectId(Object id, Class objType) {
		return delegate.createObjectId(id, objType);
	}

	@Override
	public Object getObjectId(Object object) {
		return delegate.getObjectId(object);
	}

	@Override
	public void deleteObject(Object id, Class objType) {
		delegate.deleteObject(id, objType);
	}

	@Override
	public Object findObject(Object id, Class objType) {
		return delegate.findObject(id, objType);
	}

	@Override
	public Object saveObject(Object object) {
		return delegate.saveObject(object);
	}

}