package rnd.expression;

public class PropertyExpression extends AbstractExpression {

	public static interface PropertyExpressionBuilder {

		PropertyExpression buildPropertyExpression(String prpName);

	}

	private static PropertyExpressionBuilder builder;

	protected String propertyName;

	protected PropertyExpression() {
	}

	protected PropertyExpression(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public static void setPropertyExpressionBuilder(PropertyExpressionBuilder builder) {
		PropertyExpression.builder = builder;
	}

	public static Expression getPropertyExpression(Object data) {
		return builder.buildPropertyExpression(data.toString());
	}

	@Override
	public String toString() {
		return propertyName;
	}

}
