package rnd.dao.rdbms.jdbc.rsp;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rnd.dao.rdbms.jdbc.rp.RowProcessor;
import rnd.dao.rdbms.jdbc.rp.UnitRowProcessor;

public class ListResultSetProcessor extends AbstractResultSetProcessor {

	@Override
	protected RowProcessor getRowProcessor(ResultSetMetaData rsmd) {
		return new UnitRowProcessor();
	}

	@Override
	protected Object processRowSet(ResultSet rs, RowProcessor rowProcessor) throws SQLException {
		List returnList = new ArrayList(rs.getFetchSize());
		while (rs.next()) {
			returnList.add(rowProcessor.processRow(rs));
		}
		return returnList;
	}
}
