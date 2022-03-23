package com.example.treasuremall.api.facade.order;

import com.example.treasuremall.api.domain.order.OrderTO;

import java.util.List;

/**
 * @author 小沙弥
 * @description 订单查询接口层
 * @date 2022/3/22 6:37 下午
 */
public interface OrderQueryFacade {

    /**
     * 查询所有订单
     */
    List<OrderTO> queryAllOrder();

}
