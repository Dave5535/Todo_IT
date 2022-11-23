package dao;


import java.util.Collection;


public interface BaseDao<T> {
    T persist(T model);

    Collection<T> findAll();


}
