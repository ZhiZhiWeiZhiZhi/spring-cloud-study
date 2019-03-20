package org.f.study.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * @author f
 */
@SpringBootApplication
@MapperScan(basePackages = "org.f.study.spring.common.mapper")
public class ApplicationBoot {


    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }
}
