package rnd.op.jdo;

import java.util.Collection;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import rnd.dao.jdo.JDOQLDataAccessObject;

public final class JDOPersistorDelegate implements JDOPersistor {

	private final PersistenceManagerFactory pmf;

	public JDOPersistorDelegate(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	public Object getObjectId(Object object) {
		Object id = JDOHelper.getObjectId(object);
		return id;
	}

	@Override
	public Object findObject(Object id, Class objType) {
		PersistenceManager pm = pmf.getPersistenceManager();
		try {
			return pm.getObjectById(createObjectId(id, objType));
		} finally {
			pm.close();
		}
	}
	
	@Override
	public Collection findAllObject(Object[] criteria, Object[] params, Class objType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object saveObject(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		try {
			return pm.makePersistent(object);
		} finally {
			pm.close();
		}
	}

	@Override
	public Object updateObject(Object id, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteObject(Object id, Class objType) {
		PersistenceManager pm = pmf.getPersistenceManager();
		try {
			pm.deletePersistent(findObject(id, objType));
		} finally {
			pm.close();
		}
	}

	@Override
	public Object createObjectId(Object id, Class objType) {
		PersistenceManager pm = pmf.getPersistenceManager();
		try {
			return pm.newObjectIdInstance(objType, id);
		} finally {
			pm.close();
		}

	}

	@Override
	public String getInverseOwner(Class elementType, String indexedPrpName) {
		throw new UnsupportedOperationException();
	}

	@Override
	public JDOQLDataAccessObject getDataAccessObject() {
		// TODO Auto-generated method stub
		return null;
	}

}
