package com.samoy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EmpowerController
 *
 * @author Samoy
 * @date 2024/7/25
 */
@RestController
@Slf4j
public class EmpowerController {

    @GetMapping("/empower")
    public String requestSentinel4() {
        log.info("测试Sentinel授权规则empower");
        return "Sentinel授权规则";
    }
}
