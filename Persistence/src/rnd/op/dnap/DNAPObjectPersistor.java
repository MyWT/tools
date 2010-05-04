package rnd.op.dnap;

import javax.jdo.PersistenceManagerFactory;

import rnd.dao.datastore.DataStoreDataAccessObject;
import rnd.op.jdo.JDOPersistor;
import rnd.op.jdo.JDOPersistorDelegate;
import rnd.op.jpa.JPAObjectPersistor;

public class DNAPObjectPersistor implements DataStoreDataAccessObject, JDOPersistor, JPAObjectPersistor {
	
	private JDOPersistorDelegate delegate;

	public DNAPObjectPersistor(PersistenceManagerFactory pmf) {
		delegate = new JDOPersistorDelegate(pmf);
	}

	@Override
	public String getInverseOwner(Class elementType, String indexedPrpName) {
		boolean rdbms = true;
		
		if(rdbms){
			// TODO Auto-generated method stub
		}else{
			// TODO Auto-generated method stub
		}
		
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