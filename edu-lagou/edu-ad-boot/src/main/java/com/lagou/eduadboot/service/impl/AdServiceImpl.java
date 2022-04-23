package com.lagou.eduadboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lagou.eduadboot.entity.PromotionAd;
import com.lagou.eduadboot.mapper.AdDao;
import com.lagou.eduadboot.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: edu-lagou
 * @Author: GuoAn.Sun
 * @CreateTime: 2021-02-23 16:23
 * @Description:
 */
@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdDao adDao;

    @Override
    public List<PromotionAd> getAdsBySpaceId(Integer sid) {
        QueryWrapper<PromotionAd> qw = new QueryWrapper<>();//select * from table
        qw.eq("space_id", sid); // where space_id = sid
        return adDao.selectList(qw);
    }
}
