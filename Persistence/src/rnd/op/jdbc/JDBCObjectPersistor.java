package rnd.op.jdbc;

import java.sql.Connection;

import rnd.dao.sql.jdbc.JDBCDataAccessObject;
import rnd.op.ObjectPersistor;

public interface JDBCObjectPersistor extends ObjectPersistor {

	Connection getConnection();
	
	JDBCDataAccessObject getDataAccessObject();

}