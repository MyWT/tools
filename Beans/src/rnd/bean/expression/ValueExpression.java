package rnd.bean.expression;

import rnd.bean.IndexedValueChangedEvent;
import rnd.bean.ValueChangeEvent;
import rnd.bean.ValueChangeListener;
import rnd.expression.AbstractExpression;
import rnd.expression.Expression;
import rnd.expression.XChangeEvent;
import rnd.expression.XChangeListener;

public class ValueExpression extends AbstractExpression {

	public static interface ExpressionBuilder {

		Expression buildExpression(String prpName);
	}

	private static ExpressionBuilder builder;

	protected String propertyName;

	protected ValueExpression() {
	}

	protected ValueExpression(String propertyName) {
		this.propertyName = propertyName;
	}

	public static void setPropertyExpressionBuilder(ExpressionBuilder builder) {
		ValueExpression.builder = builder;
	}

	public static Expression buildExpression(Object data) {
		return builder.buildExpression(data.toString());
	}

	@Override
	public String toString() {
		return propertyName;
	}

	public class ValueChangeListenerXChangeListenerDelegate extends XChangeListenerDelegate implements ValueChangeListener {

		public ValueChangeListenerXChangeListenerDelegate(XChangeListener xcl) {
			super(xcl);
		}

		public void valueChanged(ValueChangeEvent vce) {
			delegate.stateChanged(new XChangeEvent(vce.getSource(), vce.getOldValue(), vce.getNewValue(), ValueExpression.this));
		}

		public void indexedValueChanged(IndexedValueChangedEvent ivce) {
			throw new UnsupportedOperationException("IndexedValueChangedEvent is not support ");
		}
	}

	@Override
	protected XChangeListenerDelegate getNewXChangeListenerDelegate(XChangeListener xcl) {
		return new ValueChangeListenerXChangeListenerDelegate(xcl);
	}

}
