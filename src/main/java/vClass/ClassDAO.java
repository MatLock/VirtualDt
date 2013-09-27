package vClass;

import java.util.ArrayList;
import java.util.List;

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
	public T uniqueValue(int uniqueValue){
		Criteria criteria = SessionManager.getSession().createCriteria(entityType);
		criteria.add(Restrictions.eq("id_game", uniqueValue));
		return (T) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public T get(String name){
		Criteria criteria = SessionManager.getSession().createCriteria(entityType);
		criteria.add(Restrictions.eq("name",name));
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
	
	public void delete(int i){
		T r = get(i);
		SessionManager.getSession().delete(i);
	}

	@SuppressWarnings("unchecked")
	public List<SimpleGame> getAll() {
		return SessionManager.getSession().createCriteria(entityType).list();
	}

}
