package org.f.study.spring.boot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.f.study.spring.common.annotation.LogSet;
import org.f.study.spring.common.api.ApiVersion;
import org.f.study.spring.common.exception.BusinessException;
import org.f.study.spring.common.model.TDataTypeTest;
import org.f.study.spring.common.service.TDataTypeTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

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

    @LogSet(requestLog = true,responseLog = false)
    @RequestMapping(value = "/requestLog")
    @ResponseBody
    public String requestLog(){
        return "requestLog.";
    }

    @LogSet(requestLog = false,responseLog = true)
    @RequestMapping(value = "/responseLog")
    @ResponseBody
    public String responseLog(){
        return "responseLog.";
    }

    @RequestMapping(value = "/listPage")
    @ResponseBody
    public String listPage(Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<TDataTypeTest> list= tDataTypeTestService.selectAll();
        PageInfo<TDataTypeTest> pageInfo = new PageInfo<TDataTypeTest>(list);
        return pageInfo.toString();
    }

    @RequestMapping(value = "/sysException")
    @ResponseBody
    public String sysException(){
        Integer a=10;
        Integer b=a/0;
        log.info(b.toString());
        return "sysException";
    }

    @RequestMapping(value = "/myException")
    @ResponseBody
    public String myException(){
        if(1==1) {
            throw new BusinessException("自定义业务异常");
        }
        return "test2";
    }

    @ApiVersion(1)
    @RequestMapping(value = "/apiVersion")
    @ResponseBody
    public String apiVersion1(){
        return "test1";
    }

    @ApiVersion(2)
    @RequestMapping(value = "/apiVersion")
    @ResponseBody
    public String apiVersion2(){
        return "test2";
    }

    @Value("${db.config.name}")
    private String dbConfigName;

    @GetMapping("/dbConfigName")
    public String dbConfigName(){
        return this.dbConfigName;
    }

    @Value("${log.config.name}")
    private String logConfigName;

    @GetMapping("/logConfigName")
    public String logConfigName(){
        return this.logConfigName;
    }
}
