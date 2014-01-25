package com.yizhilu.os.user.dao.impl.userprofile;

import java.util.List;
import com.yizhilu.os.user.entity.userprofile.UserProfile;
import com.yizhilu.os.user.dao.userprofile.UserProfileDao;
import org.springframework.stereotype.Repository;
import com.yizhilu.os.core.dao.impl.common.GenericDaoImpl;

/**
 *
 * UserProfile
 * User: qinggang.liu bis@foxmail.com
 * Date: 2014-01-25
 */
 @Repository("userProfileDao")
public class UserProfileDaoImpl extends GenericDaoImpl implements UserProfileDao{

    public java.lang.Long addUserProfile(UserProfile userProfile) {
        return this.insert("UserProfileMapper.createUserProfile",userProfile);
    }

    public void deleteUserProfileById(Long id){
        this.delete("UserProfileMapper.deleteUserProfileById",id);
    }

    public void updateUserProfile(UserProfile userProfile) {
        this.update("UserProfileMapper.updateUserProfile",userProfile);
    }

    public UserProfile getUserProfileById(Long id) {
        return this.selectOne("UserProfileMapper.getUserProfileById",id);
    }

    public List<UserProfile> getUserProfileList(UserProfile userProfile) {
        return this.selectList("UserProfileMapper.getUserProfileList",userProfile);
    }
}
