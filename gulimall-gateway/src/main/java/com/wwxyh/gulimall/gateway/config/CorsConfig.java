package com.wwxyh.gulimall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @Description:
 * @Author: wwx
 * @Date: 2021/12/11 22:12
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // 设置允许跨域的请求头字段
        corsConfiguration.addAllowedHeader("*");
        // 配置运行跨域的请求方式
        corsConfiguration.addAllowedMethod("*");
        // 设置允许跨域的来源
        corsConfiguration.addAllowedOrigin("*");
        // 设置是否允许携带cookie跨域
        corsConfiguration.setAllowCredentials(true);

        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsWebFilter(source);
    }
}
