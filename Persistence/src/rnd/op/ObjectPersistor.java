package rnd.op;

public interface ObjectPersistor<T> extends ObjectLifeCycle<T> {

	Object getObjectId(Object object);

}