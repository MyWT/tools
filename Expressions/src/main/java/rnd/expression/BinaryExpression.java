package rnd.expression;

import rnd.utils.WrapperUtils;

public class BinaryExpression extends AbstractExpression {

	private Expression firstExpression;

	private Expression secondExpression;

	private BinaryOperation operation;

	public BinaryExpression() {
	}

	public BinaryExpression(Expression firstExpression, Expression secondExpression, BinaryOperation operation) {
		this.firstExpression = firstExpression;
		this.secondExpression = secondExpression;
		this.operation = operation;
	}

	@Override
	public Object getValue(Object object) {
		Object firstValue = this.firstExpression.getValue(object);
		Object secondValue = this.secondExpression.getValue(object);
		return performBinaryOperation(firstValue, secondValue);
	}

	private Object performBinaryOperation(Object firstValue, Object secondValue) {
		switch (this.operation) {
		case ADD:
			return performAddOperation(firstValue, secondValue);
		default:
			return throwUnsupportedOperationException(this.operation.toString());
		}
	}

	private Object performAddOperation(Object firstValue, Object secondValue) {

		// Check Null
		boolean isBothNull = firstValue == null && secondValue == null;
		if (isBothNull) {
			return null;
		}

		// Check Number
		boolean isNumber = firstValue instanceof Number && secondValue instanceof Number;
		if (isNumber) {
			return new Double(WrapperUtils.getDouble(firstValue) + WrapperUtils.getDouble(secondValue));
		}

		// Concat String
		String firstLiteralValue = "";
		String secondLiteralValue = "";
		if (firstValue != null) {
			firstLiteralValue = firstValue.toString();
		}
		if (secondValue != null) {
			secondLiteralValue = secondValue.toString();
		}

		return firstLiteralValue + secondLiteralValue;
	}

	// public void addXChangeListener(Object object, XChangeListener xChangeListener) {
	// XChangeListener binaryXChangeListener = (XChangeListener)
	// getXChangeListenerDelegate(xChangeListener, false);
	// this.firstExpression.addXChangeListener(object, binaryXChangeListener);
	// this.secondExpression.addXChangeListener(object, binaryXChangeListener);
	//
	// }

	// public void removeXChangeListener(Object object, XChangeListener xChangeListener) {
	// XChangeListener binaryXChangeListener = (XChangeListener)
	// getXChangeListenerDelegate(xChangeListener, true);
	// this.firstExpression.addXChangeListener(object, binaryXChangeListener);
	// this.secondExpression.addXChangeListener(object, binaryXChangeListener);
	// }

	// public class BinaryExpressionXChangeListener extends XChangeListenerDelegate implements
	// XChangeListener {
	//
	// private Object cachedOldValue;
	//
	// protected BinaryExpressionXChangeListener(XChangeListener xChangeListener) {
	// super(xChangeListener);
	// }
	//
	// public void stateChanged(XChangeEvent changeEvent) {
	// Object newValue = getValue(changeEvent.getSource());
	// this.delegate.stateChanged(new XChangeEvent(changeEvent.getSource(), this.cachedOldValue,
	// newValue, BinaryExpression.this));
	// this.cachedOldValue = newValue;
	// }
	// }

	// @Override
	// protected XChangeListenerDelegate getNewXChangeListenerDelegate(XChangeListener
	// xchangeListener) {
	// return new BinaryExpressionXChangeListener(xchangeListener);
	// }

}
