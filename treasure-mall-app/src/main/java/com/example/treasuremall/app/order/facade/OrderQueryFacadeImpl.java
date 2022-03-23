package com.example.treasuremall.app.order.facade;

import com.example.treasuremall.api.domain.order.OrderTO;
import com.example.treasuremall.api.facade.order.OrderQueryFacade;
import com.example.treasuremall.app.order.convert.OrderConvert;
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
    public List<OrderTO> queryAllOrder() {
        List<Order> orderList = orderMapper.queryAllOrder();
        return OrderConvert.transferOrderTOListFromOrderList(orderList);
    }

}
