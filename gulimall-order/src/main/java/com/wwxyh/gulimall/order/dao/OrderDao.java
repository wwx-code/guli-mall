package com.wwxyh.gulimall.order.dao;

import com.wwxyh.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author wwx
 * @email 
 * @date 2021-11-20 23:20:21
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
