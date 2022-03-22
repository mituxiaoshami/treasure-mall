package com.example.treasuremall.test;


import com.example.treasuremall.api.facade.order.OrderQueryFacade;
import org.junit.Test;

import javax.annotation.Resource;

public class Cucumber extends BaseTest{

    @Resource
    private OrderQueryFacade orderQueryFacade;

    @Test
    public void queryAllOrder() {
        orderQueryFacade.queryAllOrder();
    }

}