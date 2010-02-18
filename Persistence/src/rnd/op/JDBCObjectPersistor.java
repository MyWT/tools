package rnd.op;

import java.sql.Connection;

public interface JDBCObjectPersistor extends ObjectPersistor {

	Connection getConnection();

}
