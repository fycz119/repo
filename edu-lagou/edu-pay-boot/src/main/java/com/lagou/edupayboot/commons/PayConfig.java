package com.lagou.edupayboot.commons;


/**
 * @BelongsProject: lagou-edu-web
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-09-23 17:49
 * @Description: 微信支付商户的配置类（运行不了的商户信息）
 */
public class PayConfig {
    //企业公众号ID
    public static String appid="1";
    //财付通平台的商户帐号
    public static String partner="2";
    //财付通平台的商户密钥
    public static String partnerKey="3";
    //回调URL
    public static String notifyurl="http://localhost:8006/pay/wxCallback";

}