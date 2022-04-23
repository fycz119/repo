package com.lagou.eduadboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lagou.eduadboot.entity.PromotionAd;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: edu-lagou
 * @Author: GuoAn.Sun
 * @CreateTime: 2021-02-23 16:22
 * @Description:
 */
@Component
public interface AdDao extends BaseMapper<PromotionAd> {
//    List<PromotionAd> getAdsBySpaceId(@Param("space_id") Integer sid);
}
