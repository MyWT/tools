package rnd.dao.rdbms.jdbc.rp;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowProcessor {

	Object processRow(ResultSet rs) throws SQLException;

	void setStartIndex(int startIndex);

	void setEndIndex(int endIndex);
}
