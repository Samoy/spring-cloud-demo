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
@FeignClient("seata-account")
public interface AccountFeignApi {
    @PostMapping("/account/decrease")
    Result<Object> decease(@RequestParam Long userId, @RequestParam Long money);
}
