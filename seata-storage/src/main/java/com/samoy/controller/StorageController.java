package com.samoy.controller;

import com.samoy.enumerate.ReturnCodeEnum;
import com.samoy.service.StorageService;
import com.samoy.util.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * StorageController
 *
 * @author Samoy
 * @date 2024/7/30
 */
@RestController
public class StorageController {
    @Resource
    private StorageService service;

    @RequestMapping("/storage/decrease")
    public Result<String> decrease(Long productId, Integer count) {
        service.decrease(productId, count);
        return Result.custom(ReturnCodeEnum.RC200.getCode(), "扣减库存成功", null);
    }
}
