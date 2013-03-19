//package rnd.op.jdo;
//
//import javax.jdo.PersistenceManagerFactory;
//
//import rnd.dao.jdo.JDOQLDataAccessObject;
//
//public abstract class AbsJDOPersistor implements JDOPersistor {
//
//	private JDOPersistorDelegate delegate;
//
//	public AbsJDOPersistor(PersistenceManagerFactory pmf) {
//		delegate = new JDOPersistorDelegate(pmf);
//	}
//
//	@Override
//	public Object createObjectId(Object id, Class objType) {
//		return delegate.createObjectId(id, objType);
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
//	public JDOQLDataAccessObject getDataAccessObject() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getInverseOwner(Class elementType, String indexedPrpName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
