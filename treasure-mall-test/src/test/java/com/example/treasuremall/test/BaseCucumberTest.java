package com.example.treasuremall.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * RunWith(Cucumber.class) 这是一个运行器 ，指用Cucumber来运行测试
 * CucumberOptions中的features，用于指定我们项目中要运行的feature的目录
 * CucumberOptions中的format，用于指定我们项目中要运行时生成的报告，并指定之后可以在target目录中找到对应的测试报告
 * CucumberOptions中的glue，用于指定项目运行时查找实现step定义文件的目录
 *
 */
@RunWith(Cucumber.class)
public class BaseCucumberTest {

}
