package rnd.bean.action;

public interface ValueChangeAction {

	void performAction(ValueActionEvent vcae);

	void performAction(IndexedValueActionEvent ivce);

}
