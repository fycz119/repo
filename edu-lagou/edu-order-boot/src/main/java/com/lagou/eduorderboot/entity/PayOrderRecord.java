package com.lagou.eduorderboot.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @BelongsProject: edu-lagou
 * @Author: GuoAn.Sun
 * @CreateTime: 2021-03-08 21:28
 * @Description:
 */
@Data
@Table(name = "pay_order_record") //支付订单状态日志表
public class PayOrderRecord implements Serializable {
    private static final long serialVersionUID = 777308790778683330L;

    /**
     * 主键
     */
    @Id
    private Long id;
    private String order_no;
    private String type;
    private String from_status;
    private String to_status;
    private Double paid_amount;
    private String remark;
    private String created_by;
    private Date created_at;
}