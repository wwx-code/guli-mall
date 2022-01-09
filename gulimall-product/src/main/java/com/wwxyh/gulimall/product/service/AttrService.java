package com.wwxyh.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wwxyh.common.utils.PageUtils;
import com.wwxyh.gulimall.product.entity.AttrEntity;
import com.wwxyh.gulimall.product.vo.AttrVo;

import java.util.Map;

/**
 * 商品属性
 *
 * @author wwx
 * @email 
 * @date 2021-11-20 23:18:56
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attr);

    /**
     * 查询规格参数信息
     * @param params
     * @param catelogId
     * @param type
     * @return
     */
    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId, String type);
}

