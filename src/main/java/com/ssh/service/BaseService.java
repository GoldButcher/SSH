package com.ssh.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chenliangjun on 2017/6/10.
 */
public interface BaseService<PK extends Serializable,T> {
    T getByKey(PK key);
    T getByProperties(String propertiesName,String properties);
    PK sava(T entity);
    void update(T entity);
    void delete(T entity);
    List<T> getAll();
    Long getTotalCount();
}
