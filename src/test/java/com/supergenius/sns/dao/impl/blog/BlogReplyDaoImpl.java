package com.supergenius.sns.dao.impl.blog;

import java.util.List;
import com.supergenius.sns.entity.blog.BlogReply;
import com.supergenius.sns.dao.blog.BlogReplyDao;

import com.supergenius.sns.dao.impl.common.GenericDaoImpl;

/**
 *
 * BlogReply
 * User: qinggang.liu bis@foxmail.com
 * Date: 2013-12-26
 */
public class BlogReplyDaoImpl extends GenericDaoImpl implements BlogReplyDao{

    public java.lang.Integer addBlogReply(BlogReply blogReply) {
return this.insert("BlogReplyMapper.createBlogReply",blogReply);
    }

    public void deleteBlogReplyById(int id){
        this.delete("BlogReplyMapper.deleteBlogReplyById",id);
    }

    public void updateBlogReply(BlogReply blogReply) {
        this.update("BlogReplyMapper.updateBlogReply",blogReply);
    }

    public BlogReply getBlogReplyById(int id) {
        return this.selectOne("BlogReplyMapper.getBlogReplyById",id);
    }

    public List<BlogReply> getBlogReplyList(BlogReply blogReply) {
        return this.selectList("BlogReplyMapper.getBlogReplyList",blogReply);
    }
}
