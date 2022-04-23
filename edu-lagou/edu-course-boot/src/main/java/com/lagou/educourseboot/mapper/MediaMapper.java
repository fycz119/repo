package com.lagou.educourseboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lagou.educourseboot.entity.Course;
import com.lagou.educourseboot.entity.CourseMedia;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: edu-lagou
 * @Author: GuoAn.Sun
 * @CreateTime: 2021-03-03 15:44
 * @Description:
 */
@Component
public interface MediaMapper extends BaseMapper<CourseMedia> {
}
