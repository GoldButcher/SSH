package com.ssh.dao.impl;

import com.ssh.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by chenliangjun on 2017/6/10.
 */
public class BaseDaoImpl<PK extends Serializable,T> implements BaseDao<PK,T>{

	private final Class<T> persistentClass;

	protected BaseDaoImpl(){
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}

	@Resource
	protected SessionFactory sessionFactory;


	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }

    @Override
    public T getByProperties(String propertiesName, Object properties) {
        String hql = "From "+persistentClass.getName()+" as modal WHERE modal."+ propertiesName + "= ?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0,properties);
        return (T) query.uniqueResult();
    }

    @Override
    public void update(T entity) {
        getSession().update(entity);
    }

    public PK sava(T entity) {
        return (PK) getSession().save(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        String hql = "From "+persistentClass.getName();
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    @Override
    public Long getTotalCount() {
        String hql = "select count(*) from "+persistentClass.getName();
        Query query = getSession().createQuery(hql);
        return (Long) query.uniqueResult();
    }
}
