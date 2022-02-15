package com.wwxyh.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wwxyh.common.utils.PageUtils;
import com.wwxyh.gulimall.product.entity.SkuInfoEntity;

import java.util.Map;

/**
 * sku信息
 *
 * @author wwx
 * @email 
 * @date 2021-11-20 23:18:56
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSkuInfo(SkuInfoEntity skuInfoEntity);
}

