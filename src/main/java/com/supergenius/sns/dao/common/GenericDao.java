package com.supergenius.sns.dao.common;

import java.util.List;

/**
 * 
 * @ClassName GenericDao
 * @package com.supergenius.sns.common.dao
 * @description
 * @author liuqinggang
 * @Create Date: 2013-5-25 下午5:37:47
 * 
 */
public interface GenericDao {

    public Integer insert(String sqlKey, Object object);

    public Integer delete(String sqlKey, Object object);

    public Integer update(String key, Object object);

    public <T> T selectOne(String sqlKey, Object params);

    public <T> List<T> selectList(String sqlKey, Object params);

}
