package com.spring.cloud.study.eureka.client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class Application {
    @Value("${server.port}")
    String port;
    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return "hi "+name+",I am from port:" +port;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}