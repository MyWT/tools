package rnd.dao.jdo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import rnd.dao.rdbms.JDOQLDAOContext;

public class JDOQLDataAcessObjectImpl implements JDOQLDataAccessObject {

	@Override
	public List<Object[]> select(String[] fieldsNames, String from, String where, Object[] params, JDOQLDAOContext ctx) {

		PersistenceManager pm = ctx.getPersistenceManager();
		int rowSize = fieldsNames.length;

		StringBuilder selectQuery = new StringBuilder(" SELECT ").append(fieldsNames).append(" FROM ").append(from);
		if (where != null) {
			selectQuery.append(" WHERE ").append(where);
		}

		Query query = pm.newQuery(Query.SQL, selectQuery.toString());
		Collection coll = null;

		List<Object[]> retList = null;
		try {
			coll = (Collection) query.executeWithArray(params);
			retList = new ArrayList<Object[]>(coll.size());

			for (Object obj : coll) {

				Object[] row = new Object[rowSize];

				for (int i = 0; i < rowSize; i++) {
					row[i] = BeanUtils.getValue(obj, fieldsNames[i]);
				}

				retList.add(row);
			}

		} finally {
			query.close(coll);
		}

		return retList;
	}
}