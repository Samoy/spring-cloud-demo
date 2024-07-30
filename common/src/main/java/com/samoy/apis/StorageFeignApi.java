package com.samoy.apis;

import com.samoy.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * StorageFeignApi
 *
 * @author Samoy
 * @date 2024/7/29
 */
@FeignClient("seata-storage")
public interface StorageFeignApi {
    @PostMapping("/storage/decrease")
    Result<Object> decease(@RequestParam Long productId, @RequestParam Integer count);
}
