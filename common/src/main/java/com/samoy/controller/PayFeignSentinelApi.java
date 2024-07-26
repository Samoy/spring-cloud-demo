package com.samoy.controller;

import com.samoy.apis.PayFeignSentinelApiFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * PayFeignSentinelApi
 *
 * @author Samoy
 * @date 2024/7/26
 */
@FeignClient(value = "provider", fallback = PayFeignSentinelApiFallback.class)
public interface PayFeignSentinelApi {
    @GetMapping(value = "/pay/nacos/get/{orderNo}")
    String getPayByOrderNo(@PathVariable("orderNo") String orderNo);
}
