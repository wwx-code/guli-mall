package com.wwxyh.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wwxyh.common.utils.PageUtils;
import com.wwxyh.gulimall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author wwx
 * @email 
 * @date 2021-11-20 23:18:56
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateDetail(BrandEntity brand);
}

