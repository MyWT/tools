package rnd.expression;

import java.math.BigDecimal;
import java.util.List;

public class AggregateExpression extends AbstractExpression {

	private IndexedPropertyExpression indexedPropertyExpression;
	private AggregateOperation aggregateOperation;
	private Expression aggregateExpression;

	public AggregateExpression(IndexedPropertyExpression indexedPropertyExpression, Expression aggregateExpression, AggregateOperation aggregateOperation) {
		this.indexedPropertyExpression = indexedPropertyExpression;
		this.aggregateOperation = aggregateOperation;
		this.aggregateExpression = aggregateExpression;
	}

	@Override
	public Object getValue(Object object) {
		return performAggregateOperation(object);
	}

	private Object performAggregateOperation(Object object) {
		List indexedValue = (List) indexedPropertyExpression.getValue(object);

		switch (aggregateOperation) {
		case COUNT:
			return count(indexedValue);
		case FIRST:
			return first(indexedValue);
		case LAST:
			return last(indexedValue);
		case MAX:
			return max(indexedValue);
		case MIN:
			return min(indexedValue);
		case SUM:
			return sum(indexedValue);
		case AVG:
			return average(indexedValue);
		}

		// TODO

		return indexedValue;
	}

	private Object average(List indexedValue) {
		int count = count(indexedValue);
		if (count > 0) {
			return sum(indexedValue).divide(new BigDecimal(count));
		}
		return 0;
	}

	private BigDecimal sum(List indexedValue) {
		BigDecimal sum = BigDecimal.ZERO;
		for (Object value : indexedValue) {
			BigDecimal currValue = new BigDecimal(((Number) aggregateExpression.getValue(value)).doubleValue());
			sum = sum.add(currValue);
		}
		return sum;
	}

	private Object min(List indexedValue) {
		BigDecimal retValue = BigDecimal.ZERO;
		if (indexedValue.size() > 0) {
			retValue = new BigDecimal(((Number) aggregateExpression.getValue(indexedValue.get(0))).doubleValue());

			for (int i = 1; i < count(indexedValue); i++) {
				BigDecimal currValue = new BigDecimal(((Number) aggregateExpression.getValue(indexedValue.get(i))).doubleValue());
				if (currValue.compareTo(retValue) == -1) {
					retValue = currValue;
				}
			}
		}
		return retValue;
	}

	private Object max(List indexedValue) {
		BigDecimal retValue = BigDecimal.ZERO;
		if (indexedValue.size() > 0) {
			retValue = new BigDecimal(((Number) aggregateExpression.getValue(indexedValue.get(0))).doubleValue());

			for (int i = 1; i < count(indexedValue); i++) {
				BigDecimal currValue = new BigDecimal(((Number) aggregateExpression.getValue(indexedValue.get(i))).doubleValue());
				if (currValue.compareTo(retValue) == 1) {
					retValue = currValue;
				}
			}
		}
		return retValue;
	}

	private Object last(List indexedValue) {
		if (indexedValue.size() > 0) {
			return indexedValue.get(indexedValue.size() - 1);
		}
		return null;
	}

	private Object first(List indexedValue) {
		if (indexedValue.size() > 0) {
			return indexedValue.get(0);
		}
		return null;
	}

	private int count(List indexedValue) {
		return indexedValue.size();
	}
}
