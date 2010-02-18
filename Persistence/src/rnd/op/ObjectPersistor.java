package rnd.op;

public interface ObjectPersistor {

	// Persistence

	Object saveObject(Object object);

	Object findObject(Object id, Class objType);

	void deleteObject(Object id, Class objType);

	// Data Access

	Long getObjectId(Object applicationBean);

}