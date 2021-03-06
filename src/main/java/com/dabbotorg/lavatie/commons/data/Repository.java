package com.dabbotorg.lavatie.commons.data;

import com.dabbotorg.lavatie.commons.data.Identifiable;

import java.util.List;

public interface Repository<T extends Identifiable> {
    T findOrNull(long id);
    List<? extends T> findAll();
    List<? extends T> findAll(List<Long> ids);
    boolean delete(long id);
    T add(T entity);
    T update(T entity);
}
