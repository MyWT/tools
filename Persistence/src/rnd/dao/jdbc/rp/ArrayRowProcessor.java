package rnd.dao.jdbc.rp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArrayRowProcessor extends AbstractRowProcessor {

	public Object processRow(ResultSet rs) throws SQLException {
		// if (Debugger.D.pushCheck("rnd.sql.rp.ArrayRowProcessor.processRow")) {
		// Debugger.D.push(this, null);
		// }
		// try {
		// D.println("startIndex", startIndex);
		// D.println("endIndex", endIndex);

		Object[] row = new Object[this.endIndex - this.startIndex + 1];
		// D.println("row_len", row.length);

		for (int i = this.startIndex; i <= this.endIndex; i++) {
			row[i - this.startIndex] = rs.getObject(i);
			// D.println("row_class", row[i - startIndex].getClass());
			// D.println("row_" + (i - startIndex), row[i - startIndex]);
		}
		return row;
		// }
		// finally {
		// Debugger.D.pop("rnd.sql.rp.ArrayRowProcessor.processRow");
		// }
	}
}
