package com.yizhilu.os.core.dao.common;

import java.util.List;

import com.yizhilu.os.core.entity.GuidItem;

/**
 * 
 * @ClassName  com.supergenius.sns.dao.common.GuidDao
 * @description
 * @author : qinggang.liu 305050016@qq.com
 * @Create Date : 2013-12-18 下午7:37:29
 */
public interface GuidDao {
    /**
     * 根据字段获得唯一的id
     * @param project
     * @return
     */
    public List<GuidItem> getGuidItemByProject(String project);
    
    /**
     * 添加guidItem
     * @param guidItem
     * @return
     */
    public void addGuidItem(GuidItem guidItem);
    
    /**
     * 更新guidItem
     * @param guidItem
     * @return
     */
    public void updateGuidItem(GuidItem guidItem);
    
    
}
