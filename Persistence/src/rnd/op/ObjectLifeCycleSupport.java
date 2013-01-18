package rnd.op;

public interface ObjectLifeCycleSupport {

	<T> T saveObject(T object);

	<T> T findObject(Object id, Class<T> objType);

	void deleteObject(Object id, Class objType);

}
