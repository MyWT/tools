package rnd.expression;

import rnd.util.WrapperUtils;

public class UnaryNegationExpression extends UnaryExpression {

	public UnaryNegationExpression() {
	}

	public UnaryNegationExpression(Expression expression) {
		super(expression);
	}

	@Override
	protected Boolean performUnaryOperation(Object value) {
		return !(WrapperUtils.getBoolean(value));
	}

	@Override
	public String toString() {
		return "!(" + expression + ")";
	}

}
