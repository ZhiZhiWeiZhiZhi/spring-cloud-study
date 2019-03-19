package org.f.study.spring;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.f.study.spring.common.model.TDataTypeTest;
import org.f.study.spring.common.service.TDataTypeTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;




@RunWith(SpringRunner.class)
@SpringBootTest

public class Base {
    @Autowired
    private TDataTypeTestService tDataTypeTestService;

    @Test
    public void listPage() {
        PageHelper.startPage(3, 2);
        List<TDataTypeTest> list= tDataTypeTestService.selectAll();
        PageInfo<TDataTypeTest> pageInfo = new PageInfo<TDataTypeTest>(list);
        System.out.println("总条数："+pageInfo.getTotal());
    }
}
