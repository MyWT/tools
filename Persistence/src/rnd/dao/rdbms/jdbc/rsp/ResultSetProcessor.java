package rnd.dao.rdbms.jdbc.rsp;

import java.sql.ResultSet;
import java.sql.SQLException;

import rnd.dao.rdbms.jdbc.rsmdp.ResultSetMetaDataProcessor;

public interface ResultSetProcessor {

	Object processResultSet(ResultSet rs, ResultSetMetaDataProcessor resultSetMetaDataProcessor) throws SQLException;

}
