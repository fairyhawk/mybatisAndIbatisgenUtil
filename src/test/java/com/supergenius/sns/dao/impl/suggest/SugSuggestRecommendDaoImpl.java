package com.supergenius.sns.dao.impl.suggest;

import java.util.List;
import com.supergenius.sns.entity.suggest.SugSuggestRecommend;
import com.supergenius.sns.dao.suggest.SugSuggestRecommendDao;

import com.supergenius.sns.dao.impl.common.GenericDaoImpl;

/**
 *
 * SugSuggestRecommend
 * User: qinggang.liu bis@foxmail.com
 * Date: 2013-12-26
 */
public class SugSuggestRecommendDaoImpl extends GenericDaoImpl implements SugSuggestRecommendDao{

    public java.lang.Integer addSugSuggestRecommend(SugSuggestRecommend sugSuggestRecommend) {
return this.insert("SugSuggestRecommendMapper.createSugSuggestRecommend",sugSuggestRecommend);
    }

    public void deleteSugSuggestRecommendById(int id){
        this.delete("SugSuggestRecommendMapper.deleteSugSuggestRecommendById",id);
    }

    public void updateSugSuggestRecommend(SugSuggestRecommend sugSuggestRecommend) {
        this.update("SugSuggestRecommendMapper.updateSugSuggestRecommend",sugSuggestRecommend);
    }

    public SugSuggestRecommend getSugSuggestRecommendById(int id) {
        return this.selectOne("SugSuggestRecommendMapper.getSugSuggestRecommendById",id);
    }

    public List<SugSuggestRecommend> getSugSuggestRecommendList(SugSuggestRecommend sugSuggestRecommend) {
        return this.selectList("SugSuggestRecommendMapper.getSugSuggestRecommendList",sugSuggestRecommend);
    }
}
