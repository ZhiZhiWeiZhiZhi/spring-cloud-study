package org.f.study.spring.cloud.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by F on 2018/5/10.
 */
@FeignClient(value = "service-hi")
public interface HelloService {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);


    @RequestMapping(value = "/listPage", method = RequestMethod.GET)
    String listPage();
}
