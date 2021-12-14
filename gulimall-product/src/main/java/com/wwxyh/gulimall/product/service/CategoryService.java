package com.wwxyh.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wwxyh.common.utils.PageUtils;
import com.wwxyh.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author wwx
 * @email 
 * @date 2021-11-20 23:18:56
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询出所有分类以及子分类，以树形结构组装起来列表
     */
    List<CategoryEntity> listWithTree();

    void removeMenusByIds(List<Long> asList);
}

