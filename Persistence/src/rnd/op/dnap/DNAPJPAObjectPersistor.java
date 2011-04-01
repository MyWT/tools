package rnd.op.dnap;

import rnd.op.jpa.JPAObjectPersistor;
import rnd.op.jpa.JPAObjectPersistorDelegate;

public class DNAPJPAObjectPersistor implements JPAObjectPersistor {

	private final JPAObjectPersistorDelegate delegate;

	
	public DNAPJPAObjectPersistor() {
		delegate = new JPAObjectPersistorDelegate();
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
	public <T> T findObject(Object id, Class<T> objType) {
		return delegate.findObject(id, objType);
	}

	@Override
	public <T> T saveObject(T object) {
		return delegate.saveObject(object);
	}

}
