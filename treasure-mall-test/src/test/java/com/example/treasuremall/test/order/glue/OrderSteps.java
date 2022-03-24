package com.example.treasuremall.test.order.glue;

import com.example.treasuremall.api.domain.order.OrderTO;
import com.example.treasuremall.api.facade.order.OrderQueryFacade;
import com.example.treasuremall.test.BaseSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 小沙弥
 * @description 订单单测执行规则
 * @date 2022/3/23 6:58 下午
 */
@Slf4j
public class OrderSteps extends BaseSteps {

    @Autowired
    private OrderQueryFacade orderQueryFacade;

    @When("^查询所有订单$")
    public void queryAllOrder() {
        List<OrderTO> orderTOList = orderQueryFacade.queryAllOrder();
        log.info("订单列表查询结果:{}", orderTOList);
    }

    @Then("^所有订单查询结果$")
    public void queryAllOrderThen() {
        System.out.println("HelloWorld");
    }

    @When("^根据订单ID查询订单 \"([^\"]*)\"$")
    public void queryOrderByOrderId(String orderId) {
        log.info("根据订单ID查询订单,订单ID:{}", orderId);
        List<OrderTO> orderTOList = orderQueryFacade.queryAllOrder();
        log.info("订单列表查询结果:{}", orderTOList);
    }

    @Then("^根据订单ID查询订单返回结果$")
    public void queryOrderByOrderIdThen() {
        System.out.println("HelloWorld");
    }


    @Given("^根据条件查询订单,用例名 \"(.*)\"$")
    public void queryOrderByParam(String caseName) {
        log.info("用例名:{}", caseName);
    }

    @When("^条件 \"(.*)\"$")
    public void queryOrderByParamWhen(String param) {
        log.info("根据条件查询订单,条件:{}", param);
        List<OrderTO> orderTOList = orderQueryFacade.queryAllOrder();
        log.info("订单列表查询结果:{}", orderTOList);
    }

    @Then("^根据条件查询订单返回结果 \"([^\"]*)\"$")
    public void queryOrderByParamThen(String responseData) {
        log.info("根据条件查询订单返回结果:{}", responseData);
    }

}
