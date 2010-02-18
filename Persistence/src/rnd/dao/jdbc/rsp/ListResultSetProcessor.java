package rnd.dao.jdbc.rsp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rnd.dao.jdbc.rp.RowProcessor;
import rnd.dao.jdbc.rp.UnitRowProcessor;

public class ListResultSetProcessor extends AbstractResultSetProcessor {

	@Override
	protected RowProcessor getNewRowProcessor() {
		return new UnitRowProcessor();
	}

	@Override
	protected Object processRowSet(ResultSet rs, RowProcessor rowProcessor) throws SQLException {
		List returnList = new ArrayList(0);
		while (rs.next()) {
			returnList.add(rowProcessor.processRow(rs));
		}
		return returnList;
	}
}
