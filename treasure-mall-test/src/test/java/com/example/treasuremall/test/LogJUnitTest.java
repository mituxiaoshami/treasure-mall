package com.example.treasuremall.test;

import com.example.treasuremall.api.domain.order.OrderTO;
import com.example.treasuremall.api.facade.item.ItemQueryFacade;
import com.example.treasuremall.api.facade.order.OrderQueryFacade;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 小沙弥
 * @description 日志测试类
 * @date 2022/3/5 7:06 下午
 */
@Slf4j
public class LogJUnitTest extends BaseJUnitTest {

    @Autowired
    private OrderQueryFacade orderQueryFacade;

    @Test
    public void queryItemById(){
        List<OrderTO> orderTOList =  orderQueryFacade.queryAllOrder();
        log.info("订单列表:{}", orderTOList);
    }

}
