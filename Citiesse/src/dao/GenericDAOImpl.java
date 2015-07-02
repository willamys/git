package dao;


import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import util.connection.HibernateConnection;

/**
 *
 * @author 
 */
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

    private Class<T> entityClass;

    public abstract Class<T> getEntityClass();
    
    private Session session;

    public Session getSession() {
        try {
        	session = HibernateConnection.getSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return session;
    }

    @Override
    public void save(T object) {
        Session session = getSession();
        session.beginTransaction();
        session.save(object);
        session.flush();
        session.beginTransaction().commit();
    }
    @Override
    public Integer savereturn(T object) {
        Session session = getSession();
        session.beginTransaction();
        int id = (Integer) session.save(object);
        session.flush();
        session.beginTransaction().commit();
        return id;
    }

    @Override
    public void saveOrUpdate(T object) {
        Session session = getSession();
        session.beginTransaction();
        session.saveOrUpdate(object);
        session.flush();
        session.beginTransaction().commit();
    }

    @Override
    public void update(T object) {
        Session session = getSession();
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.beginTransaction().commit();
    }

    @Override
    public void delete(T object) {
        Session session = getSession();
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.beginTransaction().commit();
    }

    @Override
    public void deleteAll() {
        Session session = getSession();
        session.beginTransaction();
        String hql = "DELETE FROM " + getEntityClass().getSimpleName();
        Query query = session.createQuery(hql);
        query.executeUpdate();
        session.beginTransaction().commit();
    }

    @Override
    public void deleteAllWhere(String field, Object key) {
        Session session = getSession();
        session.beginTransaction();
        String hql = "DELETE FROM " + getEntityClass().getSimpleName() + " WHERE " + field + " = " + key;
        Query query = session.createQuery(hql);
        query.executeUpdate();
        session.beginTransaction().commit();
    }

    @Override
    public T searchById(int id) {
        Session session = getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(getEntityClass());
        criteria.add(Restrictions.eq("id", id));
        T object = (T) criteria.uniqueResult();
        session.beginTransaction().commit();
        return object;
    }

    @Override
    public T searchBy(String value, Object obj) {
        Session session = getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(getEntityClass());
        criteria.add(Restrictions.eq(value, obj));
        T object = (T) criteria.uniqueResult();
        session.beginTransaction().commit();
        return object;
    }

    @Override
    public List<T> listAll() {
        Session session = getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(getEntityClass());
        List<T> list = (List<T>) criteria.list();
        session.beginTransaction().commit();
        return list;
    }

    @Override
    public List<T> listAllWhere(String value, Object object) {
        Session session = getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(getEntityClass());
        criteria.add(Restrictions.eq(value, object));
        List<T> list = (List<T>) criteria.list();
        session.beginTransaction().commit();
        return list;
    }

    @Override
    public List<T> listAllWhereOrderBy(String value, Object object, String order) {
        Session session = getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(getEntityClass());
        criteria.add(Restrictions.eq(value, object));
        criteria.addOrder(Order.asc(order));
        List<T> list = (List<T>) criteria.list();
        session.beginTransaction().commit();
        return list;
    }

    @Override
    public List<T> listAllOrderBy(String value) {
        Session session = getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(getEntityClass());
        criteria.addOrder(Order.asc(value));
        List<T> list = (List<T>) criteria.list();
        session.beginTransaction().commit();
        return list;
    }

    @Override
    public List<T> listAllOrderDescBy(String value) {
        Session session = getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(getEntityClass());
        criteria.addOrder(Order.desc(value));
        List<T> list = (List<T>) criteria.list();
        session.beginTransaction().commit();
        return list;
    }

    @Override
    public int countRows() {
        Session session = getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(getEntityClass());
        criteria.setProjection(Projections.rowCount());
        int rows = (Integer) criteria.uniqueResult();
        session.beginTransaction().commit();
        return rows;
    }
}
