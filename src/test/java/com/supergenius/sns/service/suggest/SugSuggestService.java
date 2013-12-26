package com.supergenius.sns.service.suggest;

import java.util.List;
import com.supergenius.sns.entity.suggest.SugSuggest;

/**
 * SugSuggest管理接口
 * User: qinggang.liu
 * Date: 2013-12-26
 */
public interface SugSuggestService {

    /**
     * 添加SugSuggest
     * @param sugSuggest 要添加的SugSuggest
     * @return id
     */
    public java.lang.Integer addSugSuggest(SugSuggest sugSuggest);

    /**
     * 根据id删除一个SugSuggest
     * @param id 要删除的id
     */
    public void deleteSugSuggestById(int id);

    /**
     * 修改SugSuggest
     * @param sugSuggest 要修改的SugSuggest
     */
    public void updateSugSuggest(SugSuggest sugSuggest);

    /**
     * 根据id获取单个SugSuggest对象
     * @param id 要查询的id
     * @return SugSuggest
     */
    public SugSuggest getSugSuggestById(int id);

    /**
     * 根据条件获取SugSuggest列表
     * @param sugSuggest 查询条件
     * @return List<SugSuggest>
     */
    public List<SugSuggest> getSugSuggestList(SugSuggest sugSuggest);
}