package org.f.study.spring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * @author f
 */
@EnableEurekaClient
@SpringBootApplication

@MapperScan(basePackages = "org.f.study.spring.common.mapper")
public class ApplicationEurekaClient {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationEurekaClient.class, args);
    }

}