package com.lagou.educommentboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lagou.educommentboot.entity.CourseCommentFavoriteRecord;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: edu-lagou
 * @Author: GuoAn.Sun
 * @CreateTime: 2021-03-05 10:20
 * @Description:
 */
@Service
public interface CourseCommentFavoriteRecordDao extends BaseMapper<CourseCommentFavoriteRecord> {

    @Select({"SELECT * FROM course_comment_favorite_record WHERE comment_id = #{commnet_id} and is_del = 0"})
    List<CourseCommentFavoriteRecord> getFavorites( Integer commnet_id);
}
