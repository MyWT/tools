package rnd.dao.rdbms.jdbc.rsp;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import rnd.dao.rdbms.jdbc.rp.RowProcessor;
import rnd.dao.rdbms.jdbc.rp.UnitRowProcessor;

public class UnitResultSetProcessor extends AbstractResultSetProcessor {

	@Override
	protected RowProcessor getRowProcessor(ResultSetMetaData rsmd) {
		return new UnitRowProcessor();
	}

	@Override
	protected Object processRowSet(ResultSet rs, RowProcessor rowProcessor) throws SQLException {
		Object row = null;
		if (rs.next()) {
			row = rowProcessor.processRow(rs);
		}
		return row;
	}

}
