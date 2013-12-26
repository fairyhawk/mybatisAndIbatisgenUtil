package com.supergenius.sns.service.impl.suggest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.supergenius.sns.entity.suggest.SugSuggestReply;
import com.supergenius.sns.dao.suggest.SugSuggestReplyDao;
import com.supergenius.sns.service.suggest.SugSuggestReplyService;
/**
 * SugSuggestReply管理接口
 * User: qinggang.liu
 * Date: 2013-12-26
 */
@Service("sugSuggestReplyService")
public class SugSuggestReplyServiceImpl implements SugSuggestReplyService{

 	@Autowired
    private SugSuggestReplyDao sugSuggestReplyDao;
    
    /**
     * 添加SugSuggestReply
     * @param sugSuggestReply 要添加的SugSuggestReply
     * @return id
     */
    public java.lang.Integer addSugSuggestReply(SugSuggestReply sugSuggestReply){
    	return sugSuggestReplyDao.addSugSuggestReply(sugSuggestReply);
    }

    /**
     * 根据id删除一个SugSuggestReply
     * @param id 要删除的id
     */
    public void deleteSugSuggestReplyById(int id){
    	 sugSuggestReplyDao.deleteSugSuggestReplyById(id);
    }

    /**
     * 修改SugSuggestReply
     * @param sugSuggestReply 要修改的SugSuggestReply
     */
    public void updateSugSuggestReply(SugSuggestReply sugSuggestReply){
     	sugSuggestReplyDao.updateSugSuggestReply(sugSuggestReply);
    }

    /**
     * 根据id获取单个SugSuggestReply对象
     * @param id 要查询的id
     * @return SugSuggestReply
     */
    public SugSuggestReply getSugSuggestReplyById(int id){
    	return sugSuggestReplyDao.getSugSuggestReplyById( id);
    }

    /**
     * 根据条件获取SugSuggestReply列表
     * @param sugSuggestReply 查询条件
     * @return List<SugSuggestReply>
     */
    public List<SugSuggestReply> getSugSuggestReplyList(SugSuggestReply sugSuggestReply){
    	return sugSuggestReplyDao.getSugSuggestReplyList(sugSuggestReply);
    }
}