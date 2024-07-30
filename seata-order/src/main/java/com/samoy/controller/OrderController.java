package com.samoy.controller;

import com.samoy.entities.Order;
import com.samoy.service.OrderService;
import com.samoy.util.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrderController
 *
 * @author Samoy
 * @date 2024/7/29
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public Result<Order> createOrder(Order order) {
        orderService.createOrder(order);
        return Result.success(order);
    }
}
