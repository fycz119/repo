package com.lagou.eduuserboot.service.impl;

import com.lagou.eduauthorityboot.entity.User;
import com.lagou.eduuserboot.mapper.UserMapper;
import com.lagou.eduuserboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: edu-lagou
 * @Author: GuoAn.Sun
 * @CreateTime: 2021-03-02 17:41
 * @Description:
 */
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void updateUser(Integer userid, String newName, String imgfileId) {
        User user = new User();
        user.setId(userid);
        user.setName(newName);
        user.setPortrait(imgfileId);
        userMapper.updateById(user);
    }

    @Override
    public void updatePassword(Integer userid, String newPwd) {
        User user = new User();
        user.setId(userid);
        user.setPassword(newPwd);
        userMapper.updateById(user);
    }
}
