package com.lagou.eduadboot.controller;

import com.lagou.eduadboot.entity.PromotionAd;
import com.lagou.eduadboot.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongsProject: edu-lagou
 * @Author: GuoAn.Sun
 * @CreateTime: 2021-02-23 16:21
 * @Description:
 */
@RestController
@RequestMapping("ad")
@CrossOrigin //解决跨域
public class AdController {

    @Autowired
    private AdService adService;

    @GetMapping("getAdsBySpaceId/{spaceid}")
    public List<PromotionAd> getAdsBySpaceId(@PathVariable("spaceid") Integer sid){
        return adService.getAdsBySpaceId(sid);
    }
}
