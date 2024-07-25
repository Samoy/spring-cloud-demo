package com.samoy.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * 流量限制服务
 *
 * @author Samoy
 * @date 2024/7/25
 */
@Service
public class FlowLimitService {
    @SentinelResource(value = "common")
    public  void common(){
        System.out.println("----- FlowLimitService come in");
    }
}
