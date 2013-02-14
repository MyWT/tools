package rnd.op.jpersis;

import java.sql.Connection;

import jpersist.DatabaseManager;
import jpersist.JPersistException;
import rnd.op.rdbms.AbsJDBCObjectPersistor;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class JPObjectPersistor extends AbsJDBCObjectPersistor {

	private DatabaseManager dbm;

	public JPObjectPersistor() {
		dbm = DatabaseManager.getUrlDefinedDatabaseManager("mydb", 10, SQLServerDriver.class.getName(), "jdbc:sqlserver://localhost:1433;DatabaseName=mydb", null, "dbo", "sqlinst1", "sqlinst1");
	}

	@Override
	public Object saveObject(Object object) {
		try {

			dbm.saveObject(object);
		} catch (JPersistException e) {
			throw new RuntimeException(e);
		}
		return object;
	}

	@Override
	public Object updateObject(Object id, Object object) {
		try {
			dbm.saveObject(id, object);
		} catch (JPersistException e) {
			throw new RuntimeException(e);
		}
		return object;
	}

	@Override
	public Object findObject(Object id, Class objType) {
		try {
			return dbm.loadObject(id, objType);
		} catch (JPersistException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteObject(Object id, Class objType) {
		try {
			dbm.deleteObject(id, objType);
		} catch (JPersistException e) {
			throw new RuntimeException(e);
		}
	}

	public Connection getConnection() {
		try {
			return dbm.getDatabase().getConnection();
		} catch (JPersistException e) {
			throw new RuntimeException(e);
		}
	}

}
