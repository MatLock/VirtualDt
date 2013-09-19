package vClass;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class ClassDAO<T> {
	
	private Class<T> entityType;

	public ClassDAO(Class<T> entityType) {
		this.entityType = entityType;
	}

	@SuppressWarnings("unchecked")
	public T get(int id){
		return (T) SessionManager.getSession().get(entityType, id);
	}
	
	@SuppressWarnings("unchecked")
	public T get(String name){
		Criteria criteria = SessionManager.getSession().createCriteria(entityType);
		criteria.add(Restrictions.eq("NAME",name));
		return (T) criteria.uniqueResult();
	}

	public void save(T t){
		
		SessionManager.getSession().saveOrUpdate(t);
	}
	
	public void deleteAll(){
		SessionManager.getSession().createQuery("DELETE" + entityType.getName()).executeUpdate();
	}

	public void delete(String name) {
		T r = get(name);
		SessionManager.getSession().delete(r);
	}

}
