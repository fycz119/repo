package com.lagou.eduadboot.service;

import com.lagou.eduadboot.entity.PromotionAd;

import java.util.List;

/**
 * @BelongsProject: edu-lagou
 * @Author: GuoAn.Sun
 * @CreateTime: 2021-02-23 16:22
 * @Description:
 */
public interface AdService {

    List<PromotionAd> getAdsBySpaceId( Integer sid);
}
