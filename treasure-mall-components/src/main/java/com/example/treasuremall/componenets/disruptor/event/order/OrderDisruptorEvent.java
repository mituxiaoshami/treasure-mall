package com.example.treasuremall.componenets.disruptor.event.order;

import com.example.treasuremall.componenets.disruptor.event.DisruptorEvent;

/**
 * @author 小沙弥
 * @description 订单Disruptor时间
 * @date 2021/8/25 3:07 下午
 */
public class OrderDisruptorEvent extends DisruptorEvent {

    /**
     * 订单编号
     */
    private String orderNo;


    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }
}
