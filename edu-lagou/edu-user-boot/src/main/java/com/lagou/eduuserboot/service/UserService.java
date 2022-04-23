package com.lagou.eduuserboot.service;

/**
 * @BelongsProject: edu-lagou
 * @Author: GuoAn.Sun
 * @CreateTime: 2021-03-02 17:34
 * @Description:
 */
public interface UserService {
    /**
     * 修改昵称
     * @param userid    用户编号
     * @param newName 新昵称
     * @param imgfileId 新的头像地址
     */
    void updateUser(Integer userid,String newName,String imgfileId);

    /**
     * 修改密码
     * @param userid 用户编号
     * @param newPwd 新密码
     */
    void updatePassword(Integer userid,String newPwd);
}
