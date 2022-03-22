package com.example.treasuremall.app.order.mapper;

import com.example.treasuremall.app.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author 小沙弥
 * @description 订单Mapper
 * @date 2022/3/22 5:56 下午
 */
public interface OrderMapper {

    /**
     * 查询所有订单信息
     * @return 订单信息列表
     */
    List<Order> queryAllOrder();

}
