package com.supergenius.sns.dao.impl.blog;

import java.util.List;
import com.supergenius.sns.entity.blog.BlogBlog;
import com.supergenius.sns.dao.blog.BlogBlogDao;

import com.supergenius.sns.dao.impl.common.GenericDaoImpl;

/**
 *
 * BlogBlog
 * User: qinggang.liu bis@foxmail.com
 * Date: 2013-12-26
 */
public class BlogBlogDaoImpl extends GenericDaoImpl implements BlogBlogDao{

    public java.lang.Integer addBlogBlog(BlogBlog blogBlog) {
return this.insert("BlogBlogMapper.createBlogBlog",blogBlog);
    }

    public void deleteBlogBlogById(int id){
        this.delete("BlogBlogMapper.deleteBlogBlogById",id);
    }

    public void updateBlogBlog(BlogBlog blogBlog) {
        this.update("BlogBlogMapper.updateBlogBlog",blogBlog);
    }

    public BlogBlog getBlogBlogById(int id) {
        return this.selectOne("BlogBlogMapper.getBlogBlogById",id);
    }

    public List<BlogBlog> getBlogBlogList(BlogBlog blogBlog) {
        return this.selectList("BlogBlogMapper.getBlogBlogList",blogBlog);
    }
}
