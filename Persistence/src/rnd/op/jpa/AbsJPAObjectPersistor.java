//package rnd.op.jpa;
//
//import rnd.dao.jpa.JPADataAccessObject;
//
//public abstract class AbsJPAObjectPersistor implements JPAObjectPersistor {
//	private JPAObjectPersistorDelegate delegate;
//
//	public AbsJPAObjectPersistor() {
//		delegate = new JPAObjectPersistorDelegate();
//	}
//
//	@Override
//	public void deleteObject(Object id, Class objType) {
//		delegate.deleteObject(id, objType);
//	}
//
//	@Override
//	public Object findObject(Object id, Class objType) {
//		return delegate.findObject(id, objType);
//	}
//
//	@Override
//	public Object saveObject(Object object) {
//		return delegate.saveObject(object);
//	}
//
//	@Override
//	public Object updateObject(Object id, Object object) {
//		return delegate.updateObject(id, object);
//	}
//
//	@Override
//	public JPADataAccessObject getDataAccessObject() {
//		return null;
//	}
//
//}
