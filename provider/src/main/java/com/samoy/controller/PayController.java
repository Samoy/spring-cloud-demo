package com.samoy.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 服务提供者控制器
 *
 * @author Samoy
 * @date 2024/7/24
 */
@RestController
public class PayController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/pay/nacos/{id}")
    public String getPayInfo(@PathVariable("id") String id) {
        return "Nacos registry, serverPort:" + serverPort + "\t id:" + id;
    }

    @GetMapping(value = "/pay/nacos/get/{orderNo}")
    @SentinelResource(value = "getPayByOrderNo", blockHandler = "getPayByOrderNoBlockHandler")
    public String getPayByOrderNo(@PathVariable("orderNo") String orderNo) {
        return "查询成功, orderNo: " + orderNo;
    }

    public String getPayByOrderNoBlockHandler(String orderNo, BlockException e) {
        return "getPayByOrderNo不可用，触发Sentinel流控配置规则, orderNo: " + orderNo + "，原因是：" + e.getLocalizedMessage();
    }
}