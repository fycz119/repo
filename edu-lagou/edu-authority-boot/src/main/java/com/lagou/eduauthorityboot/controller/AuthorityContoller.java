package com.lagou.eduauthorityboot.controller;

import com.lagou.eduauthorityboot.entity.UserDTO;
import com.lagou.eduauthorityboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: edu-lagou
 * @Author: GuoAn.Sun
 * @CreateTime: 2021-02-24 21:48
 * @Description:
 */

@RestController
@RequestMapping("user")
@CrossOrigin
public class AuthorityContoller {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @GetMapping("login")
    public UserDTO login(String phone, String password) {
        return userService.login(phone, password);
    }

    @GetMapping("checkToken")
    public UserDTO checkToken(String token) {
        return userService.checkToken(token);
    }


    @GetMapping("logout")
    public void logout(String token) {
        // 将redis中的token删除
        System.out.println("token = " + token);
        redisTemplate.delete(token);
    }

}
