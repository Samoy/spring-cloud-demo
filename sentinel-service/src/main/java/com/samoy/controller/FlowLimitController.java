package com.samoy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 流量限制控制器
 *
 * @author Samoy
 * @date 2024/7/24
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "----test";
    }

    @GetMapping("/testB")
    public String testB() {
        return "----testB";
    }
}
