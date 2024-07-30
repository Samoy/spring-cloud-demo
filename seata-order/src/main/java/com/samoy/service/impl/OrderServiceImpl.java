package com.samoy.service.impl;

import com.samoy.apis.AccountFeignApi;
import com.samoy.apis.StorageFeignApi;
import com.samoy.entities.Order;
import com.samoy.mapper.OrderMapper;
import com.samoy.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * OrderService
 *
 * @author Samoy
 * @date 2024/7/29
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private StorageFeignApi storageFeignApi;
    @Resource
    private AccountFeignApi accountFeignApi;

    @Override
    @GlobalTransactional(name = "samoy-create-order", rollbackFor = Exception.class)
    public void createOrder(Order order) {
        // XID全局事务ID的检查
        String xid = RootContext.getXID();
        log.info("创建订单开始:" + "\t xid:{}", xid);
        order.setStatus(0);
        int result = orderMapper.insertSelective(order);
        Order orderFromDB = null;
        if (result > 0) {
            orderFromDB = orderMapper.selectOne(order);
            log.info("新建订单成功, orderFromDB info :{}", orderFromDB);
            // 扣减库存
            storageFeignApi.decease(orderFromDB.getProductId(), orderFromDB.getCount());
            // 扣减余额
            accountFeignApi.decease(orderFromDB.getUserId(), orderFromDB.getMoney());
            // 修改订单状态
            log.info("修改订单状态开始:" + "\t xid:{}", xid);
            orderFromDB.setStatus(1);
            // 更新数据库
            Example example = new Example(Order.class);
            example.createCriteria().andEqualTo("userId", orderFromDB.getUserId())
                    .andEqualTo("status", 0);
            orderMapper.updateByExampleSelective(orderFromDB, example);
        }
        log.info("结束新建订单:" + "\t xid:{}", xid);
    }
}
