package rnd.dao.jdbc.rsp;

import java.sql.ResultSet;
import java.sql.SQLException;

import rnd.dao.jdbc.rp.RowProcessor;
import rnd.dao.jdbc.rp.UnitRowProcessor;

public class UnitResultSetProcessor extends AbstractResultSetProcessor {

	@Override
	protected RowProcessor getNewRowProcessor() {
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
