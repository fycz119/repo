package com.lagou.educourseboot.service;

import com.lagou.educourseboot.entity.Course;
import com.lagou.educourseboot.entity.CourseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: edu-lagou
 * @Author: GuoAn.Sun
 * @CreateTime: 2021-03-03 15:42
 * @Description:
 */
public interface CourseService {
    /**
     * 查询全部课程信息
     * @return
     */
    List<CourseDTO> getAllCourse();
    /**
     * 查询某门课程的详细信息
     * @param courseid 课程编号
     * @return
     */
    CourseDTO getCourseById(Integer courseid);


    /**
     * 查询已登录用户购买的全部课程信息
     * @return
     */
    List<CourseDTO> getCoursesByUserId(Integer userid);


    // 查询已购买课程
    List<CourseDTO> getMyCourses(List<Object> ids);


}
