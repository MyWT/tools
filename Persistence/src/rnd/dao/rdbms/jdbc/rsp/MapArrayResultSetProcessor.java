package rnd.dao.rdbms.jdbc.rsp;

import rnd.dao.rdbms.jdbc.rp.ArrayRowProcessor;
import rnd.dao.rdbms.jdbc.rp.RowProcessor;

public class MapArrayResultSetProcessor extends MapResultSetProcessor {

	@Override
	protected RowProcessor getNewRowProcessor() {
		return new ArrayRowProcessor();
	}
}
