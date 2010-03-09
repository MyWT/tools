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

}
