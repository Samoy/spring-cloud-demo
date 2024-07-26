package com.samoy.apis;

import com.samoy.controller.PayFeignSentinelApi;
import org.springframework.stereotype.Component;

/**
 * PayFeignSentinelApiFallback
 *
 * @author Samoy
 * @date 2024/7/26
 */
@Component
public class PayFeignSentinelApiFallback implements PayFeignSentinelApi {
    public String getPayByOrderNo(String orderNo) {
        return "getPayByOrderNo降级了";
    }
}
