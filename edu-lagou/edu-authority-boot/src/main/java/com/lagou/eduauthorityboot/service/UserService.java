package com.lagou.eduauthorityboot.service;

import com.lagou.eduauthorityboot.entity.UserDTO;

/**
 * @BelongsProject: edu-lagou
 * @Author: GuoAn.Sun
 * @CreateTime: 2021-02-24 21:46
 * @Description:
 */
public interface UserService {

    UserDTO login(String phone , String password);

    UserDTO checkToken(String token);

    /**
     * 用户注册
     *
     * @param phone    手机号
     * @param password 密码
     * @param nickname 昵称
     * @param headimg 头像
     * @return 受影响的行数
     */
    Integer register( String phone, String password,String nickname,String headimg);

    UserDTO loginPhoneSms(String phoneNumber);
}
