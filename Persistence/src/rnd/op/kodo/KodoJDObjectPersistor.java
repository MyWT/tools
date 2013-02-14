package rnd.op.kodo;

import javax.jdo.PersistenceManagerFactory;

import rnd.op.jdo.AbsJDOPersistor;

public class KodoJDObjectPersistor extends AbsJDOPersistor {

	public KodoJDObjectPersistor(PersistenceManagerFactory pmf) {
		super(pmf);
	}

	// public Object saveObject(final Object object) {
	// return runTransactional(new Transactional() {
	// public Object doTransaction() {
	// Object attachedObject = delegate.attach(object);
	// return getObjectId(attachedObject);
	// }
	// });
	// }

	// public Object findObject(final Object id, final Class objType) {
	// return runTransactional(new Transactional() {
	// public Object doTransaction() {
	// Object attachedObject =
	// delegate.getObjectById(KodoObjectPersistor.this.delegate.newObjectIdInstance(objType,
	// id.toString()), true);
	//
	// delegate.getFetchConfiguration().clearFetchGroups();
	// delegate.getFetchConfiguration().addFetchGroups(getCacheFetchGroups(objType));
	//
	// delegate.refresh(attachedObject);
	// Object detachedObject = delegate.detach(attachedObject);
	//
	// return detachedObject;
	// }
	// });
	// }

	// Map<Class, Collection<String>> fetchGroupCache = new WeakHashMap<Class,
	// Collection<String>>();

	// Collection<String> getCacheFetchGroups(Class objType) {
	// Collection<String> fetchGroups = this.fetchGroupCache.get(objType);
	// if (fetchGroups == null) {
	// fetchGroups = getFetchGroup(objType);
	// this.fetchGroupCache.put(objType, fetchGroups);
	// }
	// return fetchGroups;
	// }

	// private Collection<String> getFetchGroup(Class objType) {
	// return collectFetchGroup(new LinkedList<String>(),
	// kodo.runtime.KodoObjectPersistor.getMetaData(this.delegate, objType),
	// null);
	// }

	// FIXME for cyclic Type
	// private Collection<String> collectFetchGroup(Collection<String>
	// fetchGroups, ClassMetaData
	// classMetaData, FieldMetaData inverseOwner) {
	// FieldMetaData[] fieldMetaDatas = classMetaData.getFields();
	//
	// for (int i = 0; i < fieldMetaDatas.length; i++) {
	// FieldMetaData fmd = fieldMetaDatas[i];
	//
	// String fetchGroup = fmd.getFetchGroup();
	// if (fetchGroup != null) {
	// fetchGroups.add(fetchGroup);
	// }
	// if (fmd != inverseOwner && fmd.getTypeMetaData() != null) {
	// collectFetchGroup(fetchGroups, fmd.getTypeMetaData(), null);
	// }
	// if (fmd.getElementTypeMetaData() != null) {
	// collectFetchGroup(fetchGroups, fmd.getElementTypeMetaData(),
	// fmd.getInverseOwnerMetaData());
	// }
	// }
	// return fetchGroups;
	// }

	// public void deleteObject(final Object id, final Class targetClass) {
	// runTransactional(new Transactional() {
	// public Object doTransaction() {
	// delegate.deletePersistent(KodoObjectPersistor.this.delegate.getObjectById(KodoObjectPersistor.this.delegate.newObjectIdInstance(targetClass,
	// id.toString()), true));
	// return null;
	// }
	// });
	// }

	public Long getObjectId(Object object) {
		return null;
		// Object id = super.getObjectId(object);
		// return id;
		// Id kodoId = id;
		// return id != null ? id.getKey() : getDetachedObjectId(object);
	}

	public String getInverseOwner(Class objType, String indexedPrpName) {
		return objType.getSimpleName();
		// return kodo.runtime.KodoObjectPersistor.getMetaData(this.delegate,
		// objType).getField(indexedPrpName).getInverseOwner();
	}

	// private Long getDetachedObjectId(Object object) {
	// try {
	// String stringfiedId = (String)
	// object.getClass().getMethod("jdoGetDetachedObjectId",
	// null).invoke(object, null);
	// return new Long(stringfiedId.substring(stringfiedId.lastIndexOf("-") +
	// 1));
	// } catch (Exception e) {
	// throw new RuntimeException(e);
	// }
	// }

	// private interface Transactional {
	// Object doTransaction();
	// }

	// private Object runTransactional(Transactional txl) {
	// Transaction tx = this.delegate.currentTransaction();
	// try {
	// tx.begin();
	// // this.delegate.refreshAll();
	// Object object = txl.doTransaction();
	// // this.delegate.flush();
	// tx.commit();
	// return object;
	// } catch (RuntimeException e) {
	// e.printStackTrace();
	// tx.rollback();
	// throw e;
	// }
	// }

}