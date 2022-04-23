package com.lagou.eduorderboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lagou.eduorderboot.entity.PayOrder;
import com.lagou.eduorderboot.entity.UserCourseOrder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: edu-lagou
 * @Author: GuoAn.Sun
 * @CreateTime: 2021-03-08 21:07
 * @Description:
        */
@Component
public interface PayOrderDao extends BaseMapper<PayOrder> {
}
