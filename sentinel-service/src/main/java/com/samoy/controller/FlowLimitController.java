package com.samoy.controller;

import com.samoy.service.FlowLimitService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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

    @GetMapping("/testF")
    public String testF() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----测试：新增熔断规则-慢调用比例");
        return "----testF";
    }

    @GetMapping("/testG")
    public String testG() {
        System.out.println("-----测试：新增熔断规则-异常比例");
        int[] arr = new int[]{1};
        System.out.println(arr[1]);
        return "----testG";
    }

    @GetMapping("/testH")
    public String testH() {
        System.out.println("-----测试：新增熔断规则-异常数目");
        int[] arr = new int[]{1};
        System.out.println(arr[1]);
        return "----testH";
    }
}
