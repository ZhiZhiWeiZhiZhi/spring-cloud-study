package org.f.study.spring.cloud.feign.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by F on 2018/5/10.
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello(@RequestParam String name ) {
        return helloService.hello(name);
    }

    @RequestMapping(value = "/listPage",method = RequestMethod.GET)
    String listPage( ) {
        return helloService.listPage();
    }


}
