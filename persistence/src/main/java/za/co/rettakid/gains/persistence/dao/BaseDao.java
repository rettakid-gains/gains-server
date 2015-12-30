package za.co.rettakid.gains.persistence.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lwazi Prusent on 2015/09/25.
 */
public interface BaseDao<T,P extends Serializable> {

    T read(P pk);
    List<T> read();
    void delete(T entity);
    void createOrUpdate(T entity);
    Class getEntityClass();
    void flush();

}
