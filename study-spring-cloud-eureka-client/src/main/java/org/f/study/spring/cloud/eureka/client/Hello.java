package org.f.study.spring.cloud.eureka.client;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.f.study.spring.common.service.TDataTypeTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Created by f on 2018/10/15 15:41.
 * Last Modified by:
 * Last Modified time:
 **/
@RestController
public class Hello {

    @Value("${server.port}")
    String port;

    @Autowired
    private TDataTypeTestService tDataTypeTestService;

    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {

        System.out.println("eueka-client");
        return "hi "+name+",I am from port:" +port;
    }


    @RequestMapping("/listPage")
    public PageInfo listPage(){
        PageHelper.startPage(0,11);
        return new PageInfo<>(tDataTypeTestService.selectAll());
    }
}
