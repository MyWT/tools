package rnd.dao.jdbc.rp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitRowProcessor extends AbstractRowProcessor {

	public Object processRow(ResultSet rs) throws SQLException {
		return rs.getObject(this.startIndex);
	}

}
