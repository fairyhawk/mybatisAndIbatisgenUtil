package com.supergenius.sns.service.impl.blog;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.supergenius.sns.entity.blog.BlogBlog;
import com.supergenius.sns.dao.blog.BlogBlogDao;
import com.supergenius.sns.service.blog.BlogBlogService;
/**
 * BlogBlog管理接口
 * User: qinggang.liu
 * Date: 2013-12-26
 */
@Service("blogBlogService")
public class BlogBlogServiceImpl implements BlogBlogService{

 	@Autowired
    private BlogBlogDao blogBlogDao;
    
    /**
     * 添加BlogBlog
     * @param blogBlog 要添加的BlogBlog
     * @return id
     */
    public java.lang.Integer addBlogBlog(BlogBlog blogBlog){
    	return blogBlogDao.addBlogBlog(blogBlog);
    }

    /**
     * 根据id删除一个BlogBlog
     * @param id 要删除的id
     */
    public void deleteBlogBlogById(int id){
    	 blogBlogDao.deleteBlogBlogById(id);
    }

    /**
     * 修改BlogBlog
     * @param blogBlog 要修改的BlogBlog
     */
    public void updateBlogBlog(BlogBlog blogBlog){
     	blogBlogDao.updateBlogBlog(blogBlog);
    }

    /**
     * 根据id获取单个BlogBlog对象
     * @param id 要查询的id
     * @return BlogBlog
     */
    public BlogBlog getBlogBlogById(int id){
    	return blogBlogDao.getBlogBlogById( id);
    }

    /**
     * 根据条件获取BlogBlog列表
     * @param blogBlog 查询条件
     * @return List<BlogBlog>
     */
    public List<BlogBlog> getBlogBlogList(BlogBlog blogBlog){
    	return blogBlogDao.getBlogBlogList(blogBlog);
    }
}