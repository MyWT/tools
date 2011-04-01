package rnd.op;

public interface ObjectLifeCycle {

	<T> T saveObject(T object);

	<T> T findObject(Object id, Class<T> objType);

	void deleteObject(Object id, Class objType);

}
