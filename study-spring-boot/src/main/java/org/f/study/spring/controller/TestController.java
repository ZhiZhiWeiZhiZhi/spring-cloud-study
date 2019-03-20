package org.f.study.spring.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.f.study.spring.common.model.TDataTypeTest;
import org.f.study.spring.common.service.TDataTypeTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * description
 *
 * @author f
 * @date 2019/3/20 11:16
 **/
@Controller
public class TestController {

    @Autowired
    private TDataTypeTestService tDataTypeTestService;

    @RequestMapping(value = "/")
    @ResponseBody
    void hello(){
        PageHelper.startPage(3, 2);
        List<TDataTypeTest> list= tDataTypeTestService.selectAll();
        PageInfo<TDataTypeTest> pageInfo = new PageInfo<TDataTypeTest>(list);
        System.out.println("总条数："+pageInfo.getTotal());
    }
}
