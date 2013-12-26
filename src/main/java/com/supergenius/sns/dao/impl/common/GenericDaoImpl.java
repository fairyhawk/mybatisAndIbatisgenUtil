package com.supergenius.sns.dao.impl.common;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.supergenius.sns.dao.common.GenericDao;

/**
 * 
 * @ClassName GenericDaoImpl
 * @package com.supergenius.sns.common.dao
 * @description 数据库基类 供其他dao继承
 * @author liuqinggang
 * @Create Date: 2013-2-27 上午11:05:17
 * 
 */
@Repository("genericDao")
public class GenericDaoImpl implements GenericDao {

    @Override
    public Integer insert(String sqlKey, Object object) {
        return null;
    }

    @Override
    public Integer delete(String sqlKey, Object object) {
        return null;
    }

    @Override
    public Integer update(String key, Object object) {
        return null;
    }

    @Override
    public <T> T selectOne(String sqlKey, Object params) {
        return null;
    }

    @Override
    public <T> List<T> selectList(String sqlKey, Object params) {
        return null;
    }
}
