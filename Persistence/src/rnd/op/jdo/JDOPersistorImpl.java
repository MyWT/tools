package rnd.op.jdo;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

public abstract class JDOPersistorImpl implements JDOPersistor {

	private final PersistenceManagerFactory pmf;

	public JDOPersistorImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	@Override
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
	public Object saveObject(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		try {
			return pm.makePersistent(object);
		} finally {
			pm.close();
		}
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

}
