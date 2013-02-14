package rnd.op;

public interface ObjectLifeCycleSupport<T> {

	T saveObject(T object);

	T findObject(Object id, Class<T> objType);

	T updateObject(Object id, T object);

	void deleteObject(Object id, Class<T> objType);

}
