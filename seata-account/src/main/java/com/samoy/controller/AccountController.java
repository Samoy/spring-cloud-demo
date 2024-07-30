package com.samoy.controller;

import com.samoy.enumerate.ReturnCodeEnum;
import com.samoy.service.AccountService;
import com.samoy.util.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @RequestMapping("/account/decrease")
    Result<Object> decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money) {
        accountService.decrease(userId, money);
        return Result.custom(ReturnCodeEnum.RC200.getCode(), "扣减余额 成功", null);
    }

}