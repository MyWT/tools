package rnd.dao.jdbc.rsp;

import rnd.dao.jdbc.rp.ArrayRowProcessor;
import rnd.dao.jdbc.rp.RowProcessor;

public class ArrayResultSetProcessor extends UnitResultSetProcessor {

	@Override
	protected RowProcessor getNewRowProcessor() {
		return new ArrayRowProcessor();
	}
}
