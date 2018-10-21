package com.dabbotorg.lavatie.commons;

import java.util.List;

public interface Repository<T extends Identifiable> {
    T findOrNull(long id);
    List<? extends T> findAll();
    List<? extends T> findAll(List<Long> ids);
    boolean delete(T entity);
    boolean add(T entity);
}
