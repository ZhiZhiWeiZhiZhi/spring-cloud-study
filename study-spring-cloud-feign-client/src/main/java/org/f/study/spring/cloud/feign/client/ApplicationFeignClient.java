
package org.f.study.spring.cloud.feign.client;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;



@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationFeignClient {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationFeignClient.class, args);
    }

}