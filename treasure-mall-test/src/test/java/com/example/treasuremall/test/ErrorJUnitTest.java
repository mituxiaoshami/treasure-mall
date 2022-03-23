package com.example.treasuremall.test;

import com.example.treasuremall.componenets.error.enums.impl.ItemErrorEnum;
import org.junit.Test;

/**
 * @author 小沙弥
 * @description 异常模块测试类
 * @date 2022/3/21 3:07 下午
 */
public class ErrorJUnitTest extends BaseJUnitTest {


    @Test
    public void say() {
        ItemErrorEnum.ITEM_ID_NOT_NULL.assertNotNull(null);
    }

}
