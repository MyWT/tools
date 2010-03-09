package rnd.expression;

public class IndexedPropertyExpression extends PropertyExpression {

	protected String parentPropertyName;

	protected IndexedPropertyExpression(String parentPropertyName, String propertyName) {
		super(propertyName);
		this.parentPropertyName = parentPropertyName;
	}

	public String getParentPropertyName() {
		return parentPropertyName;
	}

}
