package com.supergenius.sns.dao.blog;
import java.util.List;
import com.supergenius.sns.entity.blog.BlogBlog;

/**
 * BlogBlog管理接口
 * User: qinggang.liu
 * Date: 2013-12-26
 */
public interface BlogBlogDao {

    /**
     * 添加BlogBlog
     * @param blogBlog 要添加的BlogBlog
     * @return id
     */
    public java.lang.Integer addBlogBlog(BlogBlog blogBlog);

    /**
     * 根据id删除一个BlogBlog
     * @param id 要删除的id
     */
    public void deleteBlogBlogById(int id);

    /**
     * 修改BlogBlog
     * @param blogBlog 要修改的BlogBlog
     */
    public void updateBlogBlog(BlogBlog blogBlog);

    /**
     * 根据id获取单个BlogBlog对象
     * @param id 要查询的id
     * @return BlogBlog
     */
    public BlogBlog getBlogBlogById(int id);

    /**
     * 根据条件获取BlogBlog列表
     * @param blogBlog 查询条件
     * @return List<BlogBlog>
     */
    public List<BlogBlog> getBlogBlogList(BlogBlog blogBlog);
}