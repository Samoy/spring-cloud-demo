package com.samoy.controller;

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
}