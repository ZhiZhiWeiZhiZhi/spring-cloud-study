package tk.mybatis.springboot;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.spring.annotation.MapperScan;
import tk.mybatis.springboot.mapper.TDataTypeTestMapper;
import tk.mybatis.springboot.model.TDataTypeTest;

import java.util.List;
@Controller
@SpringBootApplication
@MapperScan(basePackages = "tk.mybatis.springboot.mapper")
public class Application {
    @Autowired
    private TDataTypeTestMapper tDataTypeTestMapper;
    @RequestMapping(value = "/")
    @ResponseBody
    void hello(){
        PageHelper.startPage(3, 2);
        List<TDataTypeTest> list= tDataTypeTestMapper.selectAll();
        PageInfo<TDataTypeTest> pageInfo = new PageInfo<TDataTypeTest>(list);
        System.out.println("总条数："+pageInfo.getTotal());
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
