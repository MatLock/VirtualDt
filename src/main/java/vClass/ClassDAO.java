package vClass;

public class ClassDAO<T> {
	
	private Class<T> entityType;

	public ClassDAO(Class<T> entityType) {
		this.entityType = entityType;
	}

	public T get(int id){
		return (T) SessionManager.getSession().get(entityType, id);
	}

	public void save(T t){
		
		SessionManager.getSession().saveOrUpdate(t);
	}

}
