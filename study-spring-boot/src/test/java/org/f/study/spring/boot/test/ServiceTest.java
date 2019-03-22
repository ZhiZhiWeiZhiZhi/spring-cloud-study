package org.f.study.spring.boot.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.f.study.spring.common.model.TDataTypeTest;
import org.f.study.spring.common.service.TDataTypeTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    private TDataTypeTestService tDataTypeTestService;

    @Test
    public void listPage() {
        PageHelper.startPage(3, 2);
        List<TDataTypeTest> list= tDataTypeTestService.selectAll();
        PageInfo<TDataTypeTest> pageInfo = new PageInfo<TDataTypeTest>(list);
        log.info(pageInfo.toString());
    }

    @Test
    public void save() {
        TDataTypeTest tDataTypeTest = new TDataTypeTest();
        int rowNum = tDataTypeTestService.save(tDataTypeTest);
        log.info("保存条数" + rowNum);
    }

    @Test
    public void deleteSave(){
       TDataTypeTest tDataTypeTest = new TDataTypeTest("172db213-a950-4816-8b83-b70038e68b16");
       int rowNum = tDataTypeTestService.deleteByPrimaryKeySafe(tDataTypeTest );
       log.info("删除条数" + rowNum);
    }
}
