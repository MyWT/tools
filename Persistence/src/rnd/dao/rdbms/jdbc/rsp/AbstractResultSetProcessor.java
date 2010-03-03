package rnd.dao.rdbms.jdbc.rsp;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import rnd.dao.rdbms.jdbc.rp.RowProcessor;
import rnd.dao.rdbms.jdbc.rsmdp.ResultSetMetaDataProcessor;

/**
 * Result Set Processor are static singltons so there is no use of non-static data
 * 
 * @author Vinod.Pahuja
 * 
 */
public abstract class AbstractResultSetProcessor implements ResultSetProcessor {

	protected AbstractResultSetProcessor() {
	}

	public final Object processResultSet(ResultSet rs, ResultSetMetaDataProcessor rsmdp) throws SQLException {

		ResultSetMetaData rsmd = rs.getMetaData();

		RowProcessor rowProcessor = getNewRowProcessor();

		rowProcessor.setEndIndex(rsmd.getColumnCount());

		Object rowSetProcessorResult = processRowSet(rs, rowProcessor);

		if (rsmdp != null) {
			Object metaDataProcessorResult = processResultSetMetaData(rsmd, rsmdp);
			return new Object[] { metaDataProcessorResult, rowSetProcessorResult };
		}
		return rowSetProcessorResult;
	}

	private Object processResultSetMetaData(ResultSetMetaData rsmd, ResultSetMetaDataProcessor rsmdp) throws SQLException {
		return rsmdp.processResultSetMetaData(rsmd);
	}

	protected abstract RowProcessor getNewRowProcessor();

	protected abstract Object processRowSet(ResultSet rs, RowProcessor rowProcessor) throws SQLException;

}
