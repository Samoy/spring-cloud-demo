package com.samoy.service.impl;

import com.samoy.mapper.AccountMapper;
import com.samoy.service.AccountService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * AccountServiceImpl
 *
 * @author Samoy
 * @date 2024/7/30
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    @Override
    public void decrease(Long userId, Long money) {
        log.info("扣减余额开始-----");
        accountMapper.decrease(userId, money);
        // int i = 1 / 0;
        log.info("扣减余额结束-----");
    }

    // 模拟超时
    private void timeout() {
        try {
            TimeUnit.SECONDS.sleep(65);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
