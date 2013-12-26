package com.supergenius.sns.dao.impl.suggest;

import java.util.List;
import com.supergenius.sns.entity.suggest.SugSuggest;
import com.supergenius.sns.dao.suggest.SugSuggestDao;

import com.supergenius.sns.dao.impl.common.GenericDaoImpl;

/**
 *
 * SugSuggest
 * User: qinggang.liu bis@foxmail.com
 * Date: 2013-12-26
 */
public class SugSuggestDaoImpl extends GenericDaoImpl implements SugSuggestDao{

    public java.lang.Integer addSugSuggest(SugSuggest sugSuggest) {
return this.insert("SugSuggestMapper.createSugSuggest",sugSuggest);
    }

    public void deleteSugSuggestById(int id){
        this.delete("SugSuggestMapper.deleteSugSuggestById",id);
    }

    public void updateSugSuggest(SugSuggest sugSuggest) {
        this.update("SugSuggestMapper.updateSugSuggest",sugSuggest);
    }

    public SugSuggest getSugSuggestById(int id) {
        return this.selectOne("SugSuggestMapper.getSugSuggestById",id);
    }

    public List<SugSuggest> getSugSuggestList(SugSuggest sugSuggest) {
        return this.selectList("SugSuggestMapper.getSugSuggestList",sugSuggest);
    }
}
