package com.lagou.eduauthorityboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @BelongsProject: edu-lagou
 * @Author: GuoAn.Sun
 * @CreateTime: 2021-02-24 21:28
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
// 数据传输对象（DTO) Data Transfer Object
public class UserDTO<User> implements Serializable {

    private static final long serialVersionUID = 1L;
    private int state;  // 操作状态
    private String message;  // 状态描述

    private User content;  // 响应内容

    private String token; // 令牌
}