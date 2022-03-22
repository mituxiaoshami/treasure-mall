package com.example.treasuremall.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @description: 项目启动类
 * scanBasePackages : 需要跨模块扫描bean，所以一定要指定扫描的包，同时需要在maven中加入想要的包依赖
 * basePackages : 需要跨模块扫描mapper，所以一定要指定扫描的包，同时需要在maven中加入想要的包依赖
 * @author 小沙弥
 * @date 2021/7/24 1:22 下午
 */
@SpringBootApplication(scanBasePackages = "com.example.treasuremall.**")
@MapperScan(basePackages = "com.example.treasuremall.app.**")
public class TreasureMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(TreasureMallApplication.class, args);
    }

}
