package rnd.dao.jdbc.rsp;

import rnd.dao.jdbc.rp.ArrayRowProcessor;
import rnd.dao.jdbc.rp.RowProcessor;

public class MapListArrayResultSetProcessor extends MapListResultSetProcessor {

	@Override
	protected RowProcessor getNewRowProcessor() {
		return new ArrayRowProcessor();
	}

}
