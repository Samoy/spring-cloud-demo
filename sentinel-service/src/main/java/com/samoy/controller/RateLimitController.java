package com.samoy.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * RateLimitController
 *
 * @author Samoy
 * @date 2024/7/25
 */
@RestController
@Slf4j
public class RateLimitController {
    @GetMapping("/rateLimit/byUrl")
    public String byUrl() {
        return "按Rest地址限流测试OK";
    }

    @GetMapping("/rateLimit/byResource")
    @SentinelResource(value = "byResourceSentinelResource", blockHandler = "handlerBlockHandler")
    public String byResource() {
        return "按资源限流测试OK，O(∩_∩)O哈哈~";
    }

    public String handlerBlockHandler(BlockException blockException) {
        return "服务不可用触发了@SentinelResource启动，o(╥﹏╥)o";
    }

    @GetMapping("/rateLimit/doAction/{p1}")
    @SentinelResource(value = "doActionSentinelResource", blockHandler = "doActionBlockHandler", fallback = "doActionFallback")
    public String doAction(@PathVariable("p1") Integer p1) {
        if (p1 == 0) {
            throw new RuntimeException("p1等于0直接异常");
        }
        return "doAction测试OK，O(∩_∩)O哈哈~";
    }

    public String doActionBlockHandler(Integer p1, BlockException blockException) {
        log.error("sentinel配置自定义限流了：{}", blockException.getMessage());
        return "sentinel配置自定义限流了";
    }

    public String doActionFallback(Integer p1, Throwable throwable) {
        log.error("程序逻辑异常了：{}", throwable.getMessage());
        return "程序逻辑异常了" + "\t" + throwable.getMessage();
    }
}
