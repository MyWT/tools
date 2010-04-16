package rnd.expression;

import rnd.utils.WrapperUtils;


public class UnaryNegationExpression extends UnaryExpression {

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
