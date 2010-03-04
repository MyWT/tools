package rnd.op.rdbms;

import java.sql.Connection;

import rnd.op.ObjectPersistor;

public interface JDBCObjectPersistor extends ObjectPersistor {

	Connection getConnection();

}