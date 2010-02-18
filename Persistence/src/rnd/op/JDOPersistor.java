package rnd.op;

public interface JDOPersistor extends ObjectPersistor {

	String getInverseOwner(Class elementType, String indexedPrpName);
	
}
