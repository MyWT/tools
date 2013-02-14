package rnd.dao.rdbms.jdbc.rsp;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import rnd.dao.rdbms.jdbc.rp.RowProcessor;
import rnd.dao.rdbms.jdbc.rsmdp.ResultSetMetaDataProcessor;

/**
 * Result Set Processor are static singltons so there is no use of non-static
 * data
 * 
 * @author Vinod.Pahuja
 * 
 */
public abstract class AbstractResultSetProcessor implements ResultSetProcessor {

	protected AbstractResultSetProcessor() {
	}

	public final Object processResultSet(ResultSet rs, ResultSetMetaDataProcessor rsmdp) throws SQLException {

		ResultSetMetaData rsmd = rs.getMetaData();

		RowProcessor rp = getRowProcessor(rsmd);

		Object rsmdpResult = null;
		if (rsmdp != null) {
			rsmdpResult = rsmdp.processResultSetMetaData(rsmd);
		}
		Object rspResult = processRowSet(rs, rp);

		if (rsmdp != null) {
			return new Object[] { rsmdpResult, rspResult };
		}
		return rspResult;
	}

	protected abstract RowProcessor getRowProcessor(ResultSetMetaData rsmd);

	protected abstract Object processRowSet(ResultSet rs, RowProcessor rowProcessor) throws SQLException;

}
