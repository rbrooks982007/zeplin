package org.zeplin.repository;

import java.util.List;

/**
 * Created by rbrooks3 on 6/21/16.
 */
public interface CachedRepository<T> {

    List<T> findAll();

    T findById(String id);

    T save(T entity);

    T update(String id, T entity);
}
