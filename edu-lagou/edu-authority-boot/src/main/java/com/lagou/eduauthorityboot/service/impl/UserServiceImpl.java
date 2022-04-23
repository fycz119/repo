package com.lagou.eduauthorityboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lagou.eduauthorityboot.entity.EduConstant;
import com.lagou.eduauthorityboot.entity.User;
import com.lagou.eduauthorityboot.entity.UserDTO;
import com.lagou.eduauthorityboot.mapper.UserMapper;
import com.lagou.eduauthorityboot.service.UserService;
import com.lagou.eduauthorityboot.tools.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: edu-lagou
 * @Author: GuoAn.Sun
 * @CreateTime: 2021-02-24 21:47
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public UserDTO login(String phone, String password) {
        UserDTO dto = new UserDTO();

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("phone",phone);
        Integer i1 = userMapper.selectCount(queryWrapper);// select count(*) from user where phone = xx
        if(i1 == 0){ // 手机号不存在
            dto.setState(EduConstant.ERROR_NOT_FOUND_PHONE_CODE);
            dto.setMessage(EduConstant.ERROR_NOT_FOUND_PHONE);
        }else{
            queryWrapper.eq("password",password);
            User user = userMapper.selectOne(queryWrapper);// select * from user where phone = x and password = y
            if(user == null){ // 帐号密码不匹配
                dto.setState(EduConstant.ERROR_PASSWORD_CODE);
                dto.setMessage(EduConstant.ERROR_PASSWORD);
            }else{ //登录成功
                dto.setState(EduConstant.LOGIN_SUCCESS_CODE);
                dto.setMessage(EduConstant.LOGIN_SUCCESS);
                // 生成token
                System.out.println(user.getId());
                String token = JwtUtil.createToken(user);
                // 将token保存到redis中，并设置过期时间
                redisTemplate.opsForValue().set(token,token,600, TimeUnit.SECONDS);
                dto.setToken(token);
                System.out.println("token = " + token);
            }
        }
        return dto;
    }

    @Override
    public UserDTO checkToken(String token) {
        UserDTO dto = new UserDTO();
        int i = JwtUtil.isVerify(token);
        if(i == 0){
            dto.setState(EduConstant.TOKEN_SUCCESS_CODE);
            dto.setMessage(EduConstant.TOKEN_SUCCESS);
            // 校验通过，重新设置redis的生命周期
            redisTemplate.opsForValue().set(token,token,600, TimeUnit.SECONDS);
        }else if(i == 1){
            dto.setState(EduConstant.TOKEN_TIMEOUT_CDOE);
            dto.setMessage(EduConstant.TOKEN_TIMEOUT);
        }else if(i == 2){
            dto.setState(EduConstant.TOKEN_NULL_CODE);
            dto.setMessage(EduConstant.TOKEN_ERROR1);
        }else{
            dto.setState(EduConstant.TOKEN_ERROR_CDOE);
            dto.setMessage(EduConstant.TOKEN_ERROR2);
        }

        return dto;
    }

    @Override
    public Integer register(String phone, String password, String nickname, String headimg) {
        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);
        user.setName(nickname);
        user.setPortrait(headimg);
        return userMapper.insert(user);
    }

    @Override
    public UserDTO loginPhoneSms(String phoneNumber) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone",phoneNumber);
        User user = userMapper.selectOne(queryWrapper);
        if(user == null){ //手机号不存在
            // 先注册
            register(phoneNumber,phoneNumber,"手机新用户","xxx");
            return loginPhoneSms(phoneNumber);
        }
        System.out.println("user = " + user);
        // 创建token
        String token = JwtUtil.createToken(user);
        // 封装DTO
        UserDTO dto = new UserDTO();
        dto.setState(EduConstant.LOGIN_SUCCESS_CODE);
        dto.setMessage(EduConstant.LOGIN_SUCCESS);
        dto.setToken(token);
        return dto;
    }
}
