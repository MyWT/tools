package rnd.expression;

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
		Object[] indexedValue = (Object[]) indexedPropertyExpression.getValue(object);
		
		// TODO
		
		return indexedValue;
	}
}
