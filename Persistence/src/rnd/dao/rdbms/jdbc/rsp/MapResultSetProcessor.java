package rnd.dao.rdbms.jdbc.rsp;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import rnd.dao.rdbms.jdbc.rp.RowProcessor;
import rnd.dao.rdbms.jdbc.rp.UnitRowProcessor;

public class MapResultSetProcessor extends AbstractResultSetProcessor {

	@Override
	protected RowProcessor getRowProcessor(ResultSetMetaData rsmd) {
		return new UnitRowProcessor();
	}

	@Override
	protected Object processRowSet(ResultSet rs, RowProcessor rowProcessor) throws SQLException {

		rowProcessor.setStartIndex(2);

		Map map = new HashMap(rs.getFetchSize());
		while (rs.next()) {
			map.put(rs.getObject(1), rowProcessor.processRow(rs));
		}
		return map;

	}
}
