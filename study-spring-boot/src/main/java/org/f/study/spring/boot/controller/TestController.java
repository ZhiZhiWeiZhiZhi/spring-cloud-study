package org.f.study.spring.boot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.f.study.spring.common.api.ApiVersion;
import org.f.study.spring.common.exception.BusinessException;
import org.f.study.spring.common.model.TDataTypeTest;
import org.f.study.spring.common.service.TDataTypeTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description
 *
 * @author f
 * @date 2019/3/20 11:16
 **/
@Slf4j
@RestController
@RequestMapping("/{version}/test")
@RefreshScope
public class TestController {

    @Autowired
    private TDataTypeTestService tDataTypeTestService;

    @RequestMapping(value = "/listPage")
    @ResponseBody
    public String listPage(Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<TDataTypeTest> list= tDataTypeTestService.selectAll();
        PageInfo<TDataTypeTest> pageInfo = new PageInfo<TDataTypeTest>(list);
        return pageInfo.toString();
    }

    @ApiVersion(1)
    @RequestMapping(value = "/test")
    @ResponseBody
    public String test1(){
        Integer a=10;
        Integer b=a/0;
        log.info(b.toString());
        return "test1";
    }

    @ApiVersion(2)
    @RequestMapping(value = "/test")
    @ResponseBody
    public String test2(){
        if(1==1) {
            throw new BusinessException("自定义业务异常");
        }
        return "test2";
    }

    @Value("${profile}")
    private String profile;

    @GetMapping("/profile")
    public String profile(){
        return this.profile;
    }
}
