package com.example.treasuremall.test;

import com.example.treasuremall.start.TreasureMallApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

/**
 * @author 小沙弥
 * @description 基础步骤
 * @date 2022/3/23 8:08 下午
 */
@ContextConfiguration(classes = TreasureMallApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = TreasureMallApplication.class)
@TestPropertySource("classpath:application-test.properties")
public class BaseSteps {

}
