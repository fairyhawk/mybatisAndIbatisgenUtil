package com.yizhilu.os.user.service.impl.userprofile;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yizhilu.os.user.entity.userprofile.UserProfile;
import com.yizhilu.os.user.dao.userprofile.UserProfileDao;
import com.yizhilu.os.user.service.userprofile.UserProfileService;
/**
 * UserProfile管理接口
 * User: qinggang.liu
 * Date: 2014-01-25
 */
@Service("userProfileService")
public class UserProfileServiceImpl implements UserProfileService{

 	@Autowired
    private UserProfileDao userProfileDao;
    
    /**
     * 添加UserProfile
     * @param userProfile 要添加的UserProfile
     * @return id
     */
    public java.lang.Long addUserProfile(UserProfile userProfile){
    	return userProfileDao.addUserProfile(userProfile);
    }

    /**
     * 根据id删除一个UserProfile
     * @param id 要删除的id
     */
    public void deleteUserProfileById(Long id){
    	 userProfileDao.deleteUserProfileById(id);
    }

    /**
     * 修改UserProfile
     * @param userProfile 要修改的UserProfile
     */
    public void updateUserProfile(UserProfile userProfile){
     	userProfileDao.updateUserProfile(userProfile);
    }

    /**
     * 根据id获取单个UserProfile对象
     * @param id 要查询的id
     * @return UserProfile
     */
    public UserProfile getUserProfileById(Long id){
    	return userProfileDao.getUserProfileById( id);
    }

    /**
     * 根据条件获取UserProfile列表
     * @param userProfile 查询条件
     * @return List<UserProfile>
     */
    public List<UserProfile> getUserProfileList(UserProfile userProfile){
    	return userProfileDao.getUserProfileList(userProfile);
    }
}