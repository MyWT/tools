package rnd.dao.rdbms;

import javax.jdo.PersistenceManager;

public interface JDOQLDAOContext extends SQLDAOContext {

	PersistenceManager getPersistenceManager();

	void setPersistenceManager(PersistenceManager pm);

}
