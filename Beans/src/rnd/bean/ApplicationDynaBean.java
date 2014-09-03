package rnd.bean;

import rnd.bean.impl.DynaConstrainedBean;

public final class ApplicationDynaBean extends DynaConstrainedBean implements ApplicationBean {

	public static final String ID = "Id";
	public static final String CLASS_NAME = "ClassName";

	public ApplicationDynaBean() {
	}

	public ApplicationDynaBean(String className) {
		setClassName(className);
	}

	public Long getId() {
		return (Long) getValue(ID);
	}

	public void setId(Long id) {
		setValue(ID, id);
	}

	public String getClassName() {
		return (String) getValue(CLASS_NAME);
	}

	public void setClassName(String className) {
		setValue(CLASS_NAME, className);
	}

	@Override
	public String toString() {
		return getClassName() + "-" + getId();
	}
}