package rnd.expression;

public abstract class UnaryExpression extends AbstractExpression {

	protected Expression expression;

	public UnaryExpression() {
	}

	public UnaryExpression(Expression expression) {
		this.expression = expression;
	}

	@Override
	public Object getValue(Object object) {
		return performUnaryOperation(expression.getValue(object));
	}

	protected abstract Object performUnaryOperation(Object value);

}
