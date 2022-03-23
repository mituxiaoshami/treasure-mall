package com.example.treasuremall.test;

import com.example.treasuremall.start.TreasureMallApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 小沙弥
 * @description 基础测试类，主要负责处理单测前置、后置部分操作
 * webEnvironment : 这个属性决定了测试类要不要启动一个 web 环境，说白了就是要不要启动一个 Tomcat 容器
 * SpringBootTest.WebEnvironment.NONE : 不启动 Tomcat 容器，这时测试类启动时就只会初始化 Spring 上下文
 * SpringBootTest.WebEnvironment.MOCK : 启动一个模拟的 Servlet 环境，这是默认值
 * SpringBootTest.WebEnvironment.RANDOM_PORT : 启动一个 Tomcat 容器，并监听一个随机的端口号
 * SpringBootTest.WebEnvironment.DEFINED_PORT : 启动一个 Tomcat 容器，并监听配置文件中定义的端口（未定义则默认监听8080）
 * 如果你要测试的方法不需要用到 Tomcat 容器，比如：测试一个 DAO 类的增删改查、测试一个 Service 类的业务方法、测试一个 Util 类的公用方法、测试一个配置文件类是否读取到了正确的值...
 *
 * TestPropertySource : 指定单元测试读取的配置文件
 * @date 2022/3/18 2:38 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = TreasureMallApplication.class)
@TestPropertySource("classpath:application-test.properties")
public class BaseJUnitTest {

}
