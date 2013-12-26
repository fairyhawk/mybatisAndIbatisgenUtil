package com.supergenius.sns.service.impl.suggest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.supergenius.sns.entity.suggest.SugSuggest;
import com.supergenius.sns.dao.suggest.SugSuggestDao;
import com.supergenius.sns.service.suggest.SugSuggestService;
/**
 * SugSuggest管理接口
 * User: qinggang.liu
 * Date: 2013-12-26
 */
@Service("sugSuggestService")
public class SugSuggestServiceImpl implements SugSuggestService{

 	@Autowired
    private SugSuggestDao sugSuggestDao;
    
    /**
     * 添加SugSuggest
     * @param sugSuggest 要添加的SugSuggest
     * @return id
     */
    public java.lang.Integer addSugSuggest(SugSuggest sugSuggest){
    	return sugSuggestDao.addSugSuggest(sugSuggest);
    }

    /**
     * 根据id删除一个SugSuggest
     * @param id 要删除的id
     */
    public void deleteSugSuggestById(int id){
    	 sugSuggestDao.deleteSugSuggestById(id);
    }

    /**
     * 修改SugSuggest
     * @param sugSuggest 要修改的SugSuggest
     */
    public void updateSugSuggest(SugSuggest sugSuggest){
     	sugSuggestDao.updateSugSuggest(sugSuggest);
    }

    /**
     * 根据id获取单个SugSuggest对象
     * @param id 要查询的id
     * @return SugSuggest
     */
    public SugSuggest getSugSuggestById(int id){
    	return sugSuggestDao.getSugSuggestById( id);
    }

    /**
     * 根据条件获取SugSuggest列表
     * @param sugSuggest 查询条件
     * @return List<SugSuggest>
     */
    public List<SugSuggest> getSugSuggestList(SugSuggest sugSuggest){
    	return sugSuggestDao.getSugSuggestList(sugSuggest);
    }
}