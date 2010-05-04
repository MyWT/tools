package rnd.validation;

import rnd.expression.Expression;
import rnd.util.WrapperUtils;

public class ExpressionValidation extends AbstractValidation {

	private Expression expression;

	public ExpressionValidation(Expression expression, String validationMessage) {
		super(validationMessage);
		this.expression = expression;
	}

	@Override
	public boolean isValid(Object object) {
		return WrapperUtils.getBoolean(expression.getValue(object));
	}

}
