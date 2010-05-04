package rnd.expression;

import java.util.ArrayList;
import java.util.List;

import rnd.util.WrapperUtils;

public class FilterExpression extends AbstractExpression {

	private IndexedPropertyExpression indexedPropertyExpression;
	private Expression filterExpression;

	public FilterExpression(IndexedPropertyExpression indexedPropertyExpression, Expression filterExpression) {
		this.indexedPropertyExpression = indexedPropertyExpression;
		this.filterExpression = filterExpression;
	}

	@Override
	public Object getValue(Object object) {

		Object[] childern = (Object[]) indexedPropertyExpression.getValue(object);

		List filteredChildren = new ArrayList();

		for (Object child : childern) {
			if (WrapperUtils.getBoolean(filterExpression.getValue(child))) {
				filteredChildren.add(filterExpression);
			}
		}

		return filteredChildren.toArray();

	}
}
