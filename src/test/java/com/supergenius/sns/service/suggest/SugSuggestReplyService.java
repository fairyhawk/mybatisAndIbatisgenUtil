package com.supergenius.sns.service.suggest;

import java.util.List;
import com.supergenius.sns.entity.suggest.SugSuggestReply;

/**
 * SugSuggestReply管理接口
 * User: qinggang.liu
 * Date: 2013-12-26
 */
public interface SugSuggestReplyService {

    /**
     * 添加SugSuggestReply
     * @param sugSuggestReply 要添加的SugSuggestReply
     * @return id
     */
    public java.lang.Integer addSugSuggestReply(SugSuggestReply sugSuggestReply);

    /**
     * 根据id删除一个SugSuggestReply
     * @param id 要删除的id
     */
    public void deleteSugSuggestReplyById(int id);

    /**
     * 修改SugSuggestReply
     * @param sugSuggestReply 要修改的SugSuggestReply
     */
    public void updateSugSuggestReply(SugSuggestReply sugSuggestReply);

    /**
     * 根据id获取单个SugSuggestReply对象
     * @param id 要查询的id
     * @return SugSuggestReply
     */
    public SugSuggestReply getSugSuggestReplyById(int id);

    /**
     * 根据条件获取SugSuggestReply列表
     * @param sugSuggestReply 查询条件
     * @return List<SugSuggestReply>
     */
    public List<SugSuggestReply> getSugSuggestReplyList(SugSuggestReply sugSuggestReply);
}