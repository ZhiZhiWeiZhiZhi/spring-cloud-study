package tk.mybatis.springboot;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import tk.mybatis.springboot.mapper.TDataTypeTestMapper;
import tk.mybatis.springboot.model.TDataTypeTest;

import java.util.List;




@RunWith(SpringRunner.class)
@SpringBootTest

public class Base {
    @Autowired
    private TDataTypeTestMapper tDataTypeTestMapper;

    @Test
    public void getTotal() {

        PageHelper.startPage(3, 2);
        List<TDataTypeTest> list= tDataTypeTestMapper.selectAll();
        PageInfo<TDataTypeTest> pageInfo = new PageInfo<TDataTypeTest>(list);
        System.out.println("总条数："+pageInfo.getTotal());
    }
}
