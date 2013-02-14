package rnd.dao.rdbms.jdbc.rsp;

import java.sql.ResultSetMetaData;

import rnd.dao.rdbms.jdbc.rp.ArrayRowProcessor;
import rnd.dao.rdbms.jdbc.rp.RowProcessor;

public class ArrayResultSetProcessor extends UnitResultSetProcessor {

	@Override
	protected RowProcessor getRowProcessor(ResultSetMetaData rsmd) {
		return new ArrayRowProcessor(rsmd);
	}
}
