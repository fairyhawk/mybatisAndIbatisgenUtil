package com.supergenius.sns.service.blog;

import java.util.List;
import com.supergenius.sns.entity.blog.BlogReply;

/**
 * BlogReply管理接口
 * User: qinggang.liu
 * Date: 2013-12-26
 */
public interface BlogReplyService {

    /**
     * 添加BlogReply
     * @param blogReply 要添加的BlogReply
     * @return id
     */
    public java.lang.Integer addBlogReply(BlogReply blogReply);

    /**
     * 根据id删除一个BlogReply
     * @param id 要删除的id
     */
    public void deleteBlogReplyById(int id);

    /**
     * 修改BlogReply
     * @param blogReply 要修改的BlogReply
     */
    public void updateBlogReply(BlogReply blogReply);

    /**
     * 根据id获取单个BlogReply对象
     * @param id 要查询的id
     * @return BlogReply
     */
    public BlogReply getBlogReplyById(int id);

    /**
     * 根据条件获取BlogReply列表
     * @param blogReply 查询条件
     * @return List<BlogReply>
     */
    public List<BlogReply> getBlogReplyList(BlogReply blogReply);
}