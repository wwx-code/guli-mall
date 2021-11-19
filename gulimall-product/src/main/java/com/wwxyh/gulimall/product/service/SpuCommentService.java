package com.wwxyh.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wwxyh.common.utils.PageUtils;
import com.wwxyh.gulimall.product.entity.SpuCommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author wwx
 * @email 
 * @date 2021-11-16 23:33:07
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

