package com.samoy.service.impl;

import com.samoy.mapper.StorageMapper;
import com.samoy.service.StorageService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * StorageServiceImpl
 *
 * @author Samoy
 * @date 2024/7/30
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageMapper mapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("扣减库存开始----");
        mapper.decrease(productId, count);
        log.info("扣减库存结束----");
    }
}
