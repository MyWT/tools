package rnd.dao.jdbc.rsp;

import rnd.dao.jdbc.rp.ArrayRowProcessor;
import rnd.dao.jdbc.rp.RowProcessor;

public class MapArrayResultSetProcessor extends MapResultSetProcessor {

	@Override
	protected RowProcessor getNewRowProcessor() {
		return new ArrayRowProcessor();
	}
}
