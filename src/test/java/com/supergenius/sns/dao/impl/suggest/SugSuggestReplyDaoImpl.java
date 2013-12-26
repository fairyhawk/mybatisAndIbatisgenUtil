package com.supergenius.sns.dao.impl.suggest;

import java.util.List;
import com.supergenius.sns.entity.suggest.SugSuggestReply;
import com.supergenius.sns.dao.suggest.SugSuggestReplyDao;

import com.supergenius.sns.dao.impl.common.GenericDaoImpl;

/**
 *
 * SugSuggestReply
 * User: qinggang.liu bis@foxmail.com
 * Date: 2013-12-26
 */
public class SugSuggestReplyDaoImpl extends GenericDaoImpl implements SugSuggestReplyDao{

    public java.lang.Integer addSugSuggestReply(SugSuggestReply sugSuggestReply) {
return this.insert("SugSuggestReplyMapper.createSugSuggestReply",sugSuggestReply);
    }

    public void deleteSugSuggestReplyById(int id){
        this.delete("SugSuggestReplyMapper.deleteSugSuggestReplyById",id);
    }

    public void updateSugSuggestReply(SugSuggestReply sugSuggestReply) {
        this.update("SugSuggestReplyMapper.updateSugSuggestReply",sugSuggestReply);
    }

    public SugSuggestReply getSugSuggestReplyById(int id) {
        return this.selectOne("SugSuggestReplyMapper.getSugSuggestReplyById",id);
    }

    public List<SugSuggestReply> getSugSuggestReplyList(SugSuggestReply sugSuggestReply) {
        return this.selectList("SugSuggestReplyMapper.getSugSuggestReplyList",sugSuggestReply);
    }
}
