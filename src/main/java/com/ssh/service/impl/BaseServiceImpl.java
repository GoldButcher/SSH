package com.ssh.service.impl;

import com.ssh.dao.BaseDao;
import com.ssh.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chenliangjun on 2017/6/10.
 */
@Transactional
public class BaseServiceImpl<PK extends Serializable,T> implements BaseService<PK ,T>{
	 private BaseDao<PK, T> baseDao;

    public BaseDao<PK, T> getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao<PK, T> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public T getByKey(PK key) {
        return baseDao.getByKey(key);
    }

    @Override
    public T getByProperties(String propertiesName, String properties) {
        return baseDao.getByProperties(propertiesName,properties);
    }

    @Override
    public void update(T entity) {
        baseDao.update(entity);
    }

    @Override
    public PK sava(T entity) {
        return baseDao.sava(entity);
    }

    @Override
    public void delete(T entity) {
        baseDao.delete(entity);
    }

    @Override
    public List<T> getAll() {
        return baseDao.getAll();
    }

    @Override
    public Long getTotalCount() {
        return baseDao.getTotalCount();
    }
}
