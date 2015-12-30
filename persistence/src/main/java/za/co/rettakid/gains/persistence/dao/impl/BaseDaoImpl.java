package za.co.rettakid.gains.persistence.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import za.co.rettakid.gains.persistence.dao.BaseDao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lwazi Prusent on 2015/09/25.
 */
@Transactional
public abstract class BaseDaoImpl<T,PK extends Serializable> implements BaseDao<T,PK> {

    @Autowired
    private SessionFactory sessionFactory;

    public T read(PK pk) {
        return (T)sessionFactory.getCurrentSession().get(getEntityClass(),pk);
    }

    public List<T> read() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(getEntityClass());
        return criteria.list();
    }

    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public void createOrUpdate(T entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
    }

    public void flush() {
        sessionFactory.getCurrentSession().flush();
    }

    public Criteria createCriteria()    {
        return sessionFactory.getCurrentSession().createCriteria(getEntityClass());
    }

}
