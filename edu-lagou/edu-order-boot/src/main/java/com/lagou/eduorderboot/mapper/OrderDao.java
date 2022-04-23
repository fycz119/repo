package com.lagou.eduorderboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lagou.eduorderboot.entity.UserCourseOrder;
import org.springframework.stereotype.Component;

@Component
public interface OrderDao extends BaseMapper<UserCourseOrder> {
}
