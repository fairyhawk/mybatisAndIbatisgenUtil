package com.supergenius.sns.dao.suggest;
import java.util.List;
import com.supergenius.sns.entity.suggest.SugSuggestRecommend;

/**
 * SugSuggestRecommend管理接口
 * User: qinggang.liu
 * Date: 2013-12-26
 */
public interface SugSuggestRecommendDao {

    /**
     * 添加SugSuggestRecommend
     * @param sugSuggestRecommend 要添加的SugSuggestRecommend
     * @return id
     */
    public java.lang.Integer addSugSuggestRecommend(SugSuggestRecommend sugSuggestRecommend);

    /**
     * 根据id删除一个SugSuggestRecommend
     * @param id 要删除的id
     */
    public void deleteSugSuggestRecommendById(int id);

    /**
     * 修改SugSuggestRecommend
     * @param sugSuggestRecommend 要修改的SugSuggestRecommend
     */
    public void updateSugSuggestRecommend(SugSuggestRecommend sugSuggestRecommend);

    /**
     * 根据id获取单个SugSuggestRecommend对象
     * @param id 要查询的id
     * @return SugSuggestRecommend
     */
    public SugSuggestRecommend getSugSuggestRecommendById(int id);

    /**
     * 根据条件获取SugSuggestRecommend列表
     * @param sugSuggestRecommend 查询条件
     * @return List<SugSuggestRecommend>
     */
    public List<SugSuggestRecommend> getSugSuggestRecommendList(SugSuggestRecommend sugSuggestRecommend);
}