package rnd.op.jpersis;

import java.sql.Connection;

import jpersist.DatabaseManager;
import jpersist.JPersistException;
import rnd.op.rdbms.JDBCObjectPersistor;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class JPObjectPersistor implements JDBCObjectPersistor {

	private DatabaseManager dbm;

	public JPObjectPersistor() {
		dbm = DatabaseManager.getUrlDefinedDatabaseManager("mydb", 10, SQLServerDriver.class.getName(), "jdbc:sqlserver://20.198.56.93:1433;DatabaseName=mydb", null, "dbo", "sqlinst1", "sqlinst1");
	}

	@Override
	public <T> T saveObject(T object) {
		try {
			dbm.saveObject(object);
		} catch (JPersistException e) {
			throw new RuntimeException(e);
		}
		return object;
	}

	@Override
	public <T> T findObject(Object id, Class<T> objType) {
		try {
			return dbm.loadObject(id, objType);
		} catch (JPersistException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteObject(Object id, Class objType) {
		// TODO Auto-generated method stub
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getObjectId(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
