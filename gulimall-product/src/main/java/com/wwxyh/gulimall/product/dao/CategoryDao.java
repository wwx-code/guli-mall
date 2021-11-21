package com.wwxyh.gulimall.product.dao;

import com.wwxyh.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author wwx
 * @email 
 * @date 2021-11-20 23:18:56
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
