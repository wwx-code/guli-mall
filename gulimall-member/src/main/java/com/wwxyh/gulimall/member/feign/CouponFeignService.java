package com.wwxyh.gulimall.member.feign;

import com.wwxyh.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description:
 * @Author: wwx
 * @Date: 2021/11/21 13:04
 */
@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    @GetMapping("/coupon/coupon/test")
    public R test();
}
