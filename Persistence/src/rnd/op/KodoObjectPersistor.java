//package rnd.op;
//
//import java.sql.Connection;
//import java.util.Collection;
//import java.util.LinkedList;
//import java.util.Map;
//import java.util.Properties;
//import java.util.WeakHashMap;
//
//public class KodoObjectPersistor implements JDOPersistor, JPAObjectPersistor {
//
//	private Properties properties;
//
//	KodoPersistenceManager delegate;
//
//	private KodoObjectPersistor() {
//		try {
//			this.properties = new Properties(null);
//			this.properties.load(getClass().getResourceAsStream("jdo.properties"));
//
//			KodoPersistenceManagerFactory pmf = (KodoPersistenceManagerFactory) JDOHelper.getPersistenceManagerFactory(this.properties);
//			this.delegate = (KodoPersistenceManager) pmf.getPersistenceManager();
//		} catch (Throwable e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
//
//	}
//
//	private static KodoObjectPersistor sharedInstance;
//
//	public static synchronized KodoObjectPersistor get() {
//		if (sharedInstance == null) {
//			sharedInstance = new KodoObjectPersistor();
//		}
//		return sharedInstance;
//	}
//
//	public Object saveObject(final Object object) {
//		return runTransactional(new Transactional() {
//			public Object doTransaction() {
//				Object attachedObject = delegate.attach(object);
//				return getObjectId(attachedObject);
//			}
//		});
//	}
//
//	public Object findObject(final Object id, final Class objType) {
//		return runTransactional(new Transactional() {
//			public Object doTransaction() {
//				Object attachedObject = delegate.getObjectById(KodoObjectPersistor.this.delegate.newObjectIdInstance(objType, id.toString()), true);
//
//				delegate.getFetchConfiguration().clearFetchGroups();
//				delegate.getFetchConfiguration().addFetchGroups(getCacheFetchGroups(objType));
//
//				delegate.refresh(attachedObject);
//				Object detachedObject = delegate.detach(attachedObject);
//
//				return detachedObject;
//			}
//		});
//	}
//
//	Map<Class, Collection<String>> fetchGroupCache = new WeakHashMap<Class, Collection<String>>();
//
//	Collection<String> getCacheFetchGroups(Class objType) {
//		Collection<String> fetchGroups = this.fetchGroupCache.get(objType);
//		if (fetchGroups == null) {
//			fetchGroups = getFetchGroup(objType);
//			this.fetchGroupCache.put(objType, fetchGroups);
//		}
//		return fetchGroups;
//	}
//
//	private Collection<String> getFetchGroup(Class objType) {
//		return collectFetchGroup(new LinkedList<String>(), kodo.runtime.KodoObjectPersistor.getMetaData(this.delegate, objType), null);
//	}
//
//	// FIXME for cyclic Type
//	private Collection<String> collectFetchGroup(Collection<String> fetchGroups, ClassMetaData classMetaData, FieldMetaData inverseOwner) {
//		FieldMetaData[] fieldMetaDatas = classMetaData.getFields();
//
//		for (int i = 0; i < fieldMetaDatas.length; i++) {
//			FieldMetaData fmd = fieldMetaDatas[i];
//
//			String fetchGroup = fmd.getFetchGroup();
//			if (fetchGroup != null) {
//				fetchGroups.add(fetchGroup);
//			}
//			if (fmd != inverseOwner && fmd.getTypeMetaData() != null) {
//				collectFetchGroup(fetchGroups, fmd.getTypeMetaData(), null);
//			}
//			if (fmd.getElementTypeMetaData() != null) {
//				collectFetchGroup(fetchGroups, fmd.getElementTypeMetaData(), fmd.getInverseOwnerMetaData());
//			}
//		}
//		return fetchGroups;
//	}
//
//	public void deleteObject(final Object id, final Class targetClass) {
//		runTransactional(new Transactional() {
//			public Object doTransaction() {
//				delegate.deletePersistent(KodoObjectPersistor.this.delegate.getObjectById(KodoObjectPersistor.this.delegate.newObjectIdInstance(targetClass, id.toString()), true));
//				return null;
//			}
//		});
//	}
//
//	public Connection getConnection() {
//		return (Connection) this.delegate.getConnection();
//	}
//
//	public Long getObjectId(Object object) {
//		Id id = ((Id) JDOHelper.getObjectId(object));
//		return id != null ? id.getKey() : getDetachedObjectId(object);
//	}
//
//	public String getInverseOwner(Class objType, String indexedPrpName) {
//		return kodo.runtime.KodoObjectPersistor.getMetaData(this.delegate, objType).getField(indexedPrpName).getInverseOwner();
//	}
//
//	private Long getDetachedObjectId(Object object) {
//		try {
//			String stringfiedId = (String) object.getClass().getMethod("jdoGetDetachedObjectId", null).invoke(object, null);
//			return new Long(stringfiedId.substring(stringfiedId.lastIndexOf("-") + 1));
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	@Override
//	protected void finalize() throws Throwable {
//		this.delegate.getPersistenceManagerFactory().close();
//		this.delegate.close();
//	}
//
//	private interface Transactional {
//		Object doTransaction();
//	}
//
//	private Object runTransactional(Transactional txl) {
//		Transaction tx = this.delegate.currentTransaction();
//		try {
//			tx.begin();
//			// this.delegate.refreshAll();
//			Object object = txl.doTransaction();
//			// this.delegate.flush();
//			tx.commit();
//			return object;
//		} catch (RuntimeException e) {
//			e.printStackTrace();
//			tx.rollback();
//			throw e;
//		}
//	}
//}