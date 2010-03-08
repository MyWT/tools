package rnd.dao.rdbms.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import rnd.dao.rdbms.SQLDAOContext;
import rnd.dao.rdbms.SQLDataAccessObject;
import rnd.dao.rdbms.jdbc.rsmdp.ResultSetMetaDataProcessor;
import rnd.dao.rdbms.jdbc.rsp.ArrayResultSetProcessor;
import rnd.dao.rdbms.jdbc.rsp.ListArrayResultSetProcessor;
import rnd.dao.rdbms.jdbc.rsp.ListResultSetProcessor;
import rnd.dao.rdbms.jdbc.rsp.MapArrayResultSetProcessor;
import rnd.dao.rdbms.jdbc.rsp.MapListArrayResultSetProcessor;
import rnd.dao.rdbms.jdbc.rsp.MapListResultSetProcessor;
import rnd.dao.rdbms.jdbc.rsp.MapResultSetProcessor;
import rnd.dao.rdbms.jdbc.rsp.ResultSetProcessor;
import rnd.dao.rdbms.jdbc.rsp.UnitResultSetProcessor;

public class JDBCDataAccessObject implements SQLDataAccessObject {

	private JDBCDataAccessObject() {
	}

	// Unit : It is a atomic value
	// Array : It is a horizenal row
	
	// List : It is a collection of Row (Unit/Array)
	// Map : It map First Unit to rest Row (Unit/Array)

	public static ResultSetProcessor UnitResultSetProcessor = new UnitResultSetProcessor();

	public static ResultSetProcessor ArrayResultSetProcessor = new ArrayResultSetProcessor();

	public static ResultSetProcessor ListResultSetProcessor = new ListResultSetProcessor();

	public static ResultSetProcessor ListArrayResultSetProcessor = new ListArrayResultSetProcessor();

	public static ResultSetProcessor MapResultSetProcessor = new MapResultSetProcessor();

	public static ResultSetProcessor MapArrayResultSetProcessor = new MapArrayResultSetProcessor();

	public static ResultSetProcessor MapListResultSetProcessor = new MapListResultSetProcessor();

	public static ResultSetProcessor MapListArrayResultSetProcessor = new MapListArrayResultSetProcessor();

	private static JDBCDataAccessObject sharedInstance;

	public static synchronized JDBCDataAccessObject get() {
		if (sharedInstance == null) {
			sharedInstance = new JDBCDataAccessObject();
		}
		return sharedInstance;
	}

	private static interface StatementExecutor {

		Object executeStatement(Statement stat) throws SQLException;

	}

	// executeQuery

	public Object executeQuery(String qry, ResultSetProcessor rsp, Connection conn, boolean closeConnn) {
		return executeQuery(qry, null, rsp, conn, closeConnn);
	}

	public Object executeQuery(final String qry, final Object[] param, final ResultSetProcessor rsp, Connection conn, boolean closeConn) {
		return executeQuery(qry, null, rsp, null, conn, closeConn);

	}

	public Object executeQuery(final String query, final Object[] param, final ResultSetProcessor rsp, final ResultSetMetaDataProcessor rsmdp, Connection conn, boolean closeConn) {
		return executeStatement(query, param, new StatementExecutor() {
			public Object executeStatement(Statement stmt) throws SQLException {
				ResultSet rs = stmt.executeQuery(decorateQuery(query, param));
				Object retVal = rsp.processResultSet(rs, rsmdp);
				return retVal;
			}
		}, conn, closeConn);
	}

	// executeUpdate

	public int executeUpdate(String query, Connection conn, boolean closeConnection) {
		return executeUpdate(query, null, conn, closeConnection);
	}

	public int executeUpdate(final String query, final Object[] param, Connection conn, boolean closeConnection) {
		return (Integer) executeStatement(query, param, new StatementExecutor() {
			public Object executeStatement(Statement stat) throws SQLException {
				Integer result = stat.executeUpdate(decorateQuery(query, param));
				return result;
			}
		}, conn, closeConnection);
	}

	// execute

	public Object execute(final String query, final ResultSetProcessor resultSetProcessor, Connection conn, boolean closeConnection) {
		return execute(query, null, resultSetProcessor, conn, closeConnection);
	}

	public Object execute(final String query, final Object[] param, final ResultSetProcessor resultSetProcessor, Connection conn, boolean closeConnection) {
		return execute(query, null, resultSetProcessor, null, conn, closeConnection);
	}

	public Object execute(final String query, final Object[] param, final ResultSetProcessor resultSetProcessor, final ResultSetMetaDataProcessor rsmdp, Connection conn, boolean closeConnection) {
		return executeStatement(query, param, new StatementExecutor() {
			public Object executeStatement(Statement stat) throws SQLException {
				boolean result = stat.execute(decorateQuery(query, param));
				if (result) {
					return resultSetProcessor.processResultSet(stat.getResultSet(), rsmdp);
				}
				return stat.getUpdateCount();
			}
		}, conn, closeConnection);
	}

	// execute Statement

	private Object executeStatement(String query, Object[] param, StatementExecutor statementExecutor, Connection conn, boolean closeConnection) {
		Statement stat = null;
		try {
			return statementExecutor.executeStatement(conn.createStatement());
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			finallyClose(null, stat, conn, closeConnection);
		}
	}

	// finally Close

	private void finallyClose(ResultSet rs, Statement stat, Connection conn, boolean closeConnection) {
		if (closeConnection) {
			finallyClose(rs, stat, conn);
		} else {
			finallyClose(rs, stat);
		}
	}

	private void finallyClose(ResultSet rs, Statement ps) {
		finallyClose(rs, ps, null);
	}

	private void finallyClose(ResultSet rs, Statement ps, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	// decorate Query : Replace '?' with Parmeter
	// TODO : This decoration does not handle null parametet in case a of 'where' cluase

	private static DateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	private String decorateQuery(String query, Object[] param) {
		StringBuffer queryBuffer = new StringBuffer(query);

		if (param != null) {
			int index = 0;
			for (int i = 0; i < param.length; i++) {
				index = queryBuffer.indexOf("?", index);
				if (index != -1) {
					queryBuffer.setCharAt(index, ' ');
					String parameter = "null";
					if (param[i] != null) {
						parameter = String.valueOf(param[i]);
						if (param[i] instanceof Date) {
							parameter = "'" + sqlDateFormat.format((Date) param[i]) + "'";
						}
						if (param[i] instanceof String) {
							parameter = "'" + parameter + "'";
						}
					}
					queryBuffer.insert(index, parameter);
					index += parameter.length();
				} else {
					break;
				}
			}
		}
		return queryBuffer.toString();
	}

	@Override
	public Object select(String[] fieldsNames, String from, String where, Object[] params, SQLDAOContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
}