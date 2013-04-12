package rnd.expression;

public interface Expression {

	public static interface ExpressionBuilder {

		Expression buildExpression(Object data);
	}

	void setValue(Object object, Object value);

	Object getValue(Object object);

	void addXChangeListener(Object object, XChangeListener xChangeListener);

	void removeXChangeListener(Object object, XChangeListener xChangeListener);
}