package rnd.op.jdo;

import rnd.op.ObjectPersistor;

public interface JDOPersistor extends ObjectPersistor {

	String getInverseOwner(Class elementType, String indexedPrpName);

	Object createObjectId(Object id, Class objType);

}
