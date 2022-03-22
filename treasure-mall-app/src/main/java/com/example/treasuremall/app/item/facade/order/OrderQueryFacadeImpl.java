package com.example.treasuremall.app.item.facade.order;

import com.example.treasuremall.api.facade.order.OrderQueryFacade;
import com.example.treasuremall.app.order.entity.Order;
import com.example.treasuremall.app.order.mapper.OrderMapper;
import com.example.treasuremall.componenets.log.LogRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 小沙弥
 * @description 订单查询接口层实现
 * @date 2022/3/22 6:38 下午
 */
@Slf4j
@Service("orderQueryFacade")
public class OrderQueryFacadeImpl implements OrderQueryFacade {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public void queryAllOrder() {
        List<Order> orderList = orderMapper.queryAllOrder();
        log.info("订单列表:{}", orderList);
    }

}
