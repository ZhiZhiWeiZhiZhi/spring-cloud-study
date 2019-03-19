package org.f.study.spring;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.f.study.spring.common.model.TDataTypeTest;
import org.f.study.spring.common.service.TDataTypeTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;


/**
 * @author f
 */
@Controller
@SpringBootApplication
@MapperScan(basePackages = "org.f.study.spring.common.mapper")
public class ApplicationBoot {
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

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }
}
