package rnd.op;

import java.util.Collection;

public interface ObjectLifeCycleSupport<T> {

	T saveObject(T object);

	T findObject(Object id, Class<T> objType);

	Collection<T> findAllObject(Object[] criteria, Object[] params, Class<T> objType);

	T updateObject(Object id, T object);

	void deleteObject(Object id, Class<T> objType);

}
