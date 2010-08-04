package rnd.expression;

public class LiteralExpression extends AbstractExpression {

	Object literalValue;

	public LiteralExpression() {
	}

	public LiteralExpression(Object literalValue) {
		this.literalValue = literalValue;
	}

	public Object getValue(Object object) {
		return this.literalValue;
	}

	@Override
	public String toString() {
		return String.valueOf(literalValue);
	}

}
