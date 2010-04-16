package rnd.expression;

import java.io.Serializable;
import java.util.HashMap;

public class AbstractExpression implements Expression, Serializable {

	public void addXChangeListener(Object object, XChangeListener xChangeListener) {
	}

	public void removeXChangeListener(Object object, XChangeListener xChangeListener) {
	}

	public Object getValue(Object object) {
		throw new UnsupportedOperationException("Get Value Not Supported in (" + this + ")");
	}

	public void setValue(Object object, Object value) {
		throw new UnsupportedOperationException("Set Value Not Supported in (" + this + ")");
	}

	// XChange Listener Delegate

	public static class XChangeListenerDelegate {

		protected XChangeListener delegate;

		protected XChangeListenerDelegate(XChangeListener xChangeListener) {
			this.delegate = xChangeListener;
		}
	}

	private HashMap<XChangeListener, XChangeListenerDelegate> changeListenerDelegateMap = new HashMap<XChangeListener, XChangeListenerDelegate>(0);

	protected final XChangeListenerDelegate getXChangeListenerDelegate(XChangeListener xChangeListener, boolean remove) {
		XChangeListenerDelegate xclDelegate = this.changeListenerDelegateMap.get(xChangeListener);

		if (xclDelegate == null) {
			if (!remove) {
				xclDelegate = getNewXChangeListenerDelegate(xChangeListener);
				this.changeListenerDelegateMap.put(xChangeListener, xclDelegate);
			}
		}
		return xclDelegate;
	}

	protected XChangeListenerDelegate getNewXChangeListenerDelegate(XChangeListener xChangeListener) {
		throw new UnsupportedOperationException("Operation Should be implmented by Derived Class");
	}

}