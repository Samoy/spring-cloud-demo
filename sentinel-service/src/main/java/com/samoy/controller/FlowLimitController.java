package com.samoy.controller;

import com.samoy.service.FlowLimitService;
import jakarta.annotation.Resource;
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
    @Resource
    private FlowLimitService flowLimitService;

    @GetMapping("/testA")
    public String testA() {
        return "----testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "----testB";
    }

    @GetMapping("/testC")
    public String testC() {
        flowLimitService.common();
        return "----testC";
    }

    @GetMapping("/testD")
    public String testD() {
        flowLimitService.common();
        return "----testD";
    }

    /**
     * 流控效果----排队等待
     */
    @GetMapping("/testE")
    public String testE() {
        System.out.println(System.currentTimeMillis() + "     testE,流控效果----排队等待");
        return "----testE";
    }
}
