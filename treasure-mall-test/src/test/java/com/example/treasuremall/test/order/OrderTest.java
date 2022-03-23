package com.example.treasuremall.test.order;

import com.example.treasuremall.test.BaseCucumberTest;
import cucumber.api.CucumberOptions;

/**
 * @author 小沙弥
 * @description 订单Test
 * @date 2022/3/23 6:52 下午
 */
@CucumberOptions(features = { "classpath:features/order/Order.feature" }, plugin = { "pretty",
        "json:target/cucumber/order/order.json" }, strict = true, glue = {"com.example.treasuremall.test.order.glue" })
public class OrderTest extends BaseCucumberTest {

}
