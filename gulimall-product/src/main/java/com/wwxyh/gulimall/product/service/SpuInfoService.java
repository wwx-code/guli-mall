package com.wwxyh.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wwxyh.common.utils.PageUtils;
import com.wwxyh.gulimall.product.entity.SpuInfoEntity;
import com.wwxyh.gulimall.product.vo.SpuSaveVo;

import java.util.Map;

/**
 * spu信息
 *
 * @author wwx
 * @email 
 * @date 2021-11-20 23:18:56
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void savesupInfo(SpuSaveVo vo);

    void saveBaseSpuInfo(SpuInfoEntity spuInfoEntity);

    PageUtils queryPageByCondtion(Map<String, Object> params);
}

