package rnd.expression;

import java.util.EventObject;

public class XChangeEvent extends EventObject {

	private Object oldValue;

	private Object newValue;

	private Expression expression;

	public XChangeEvent(Object source, Object oldValue, Object newValue, Expression expression) {
		super(source);
		this.oldValue = oldValue;
		this.newValue = newValue;
		this.expression = expression;
	}

	public Object getOldValue() {
		return this.oldValue;
	}

	public Object getNewValue() {
		return this.newValue;
	}

	public Expression getExpression() {
		return this.expression;
	}

}
