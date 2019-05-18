package com.damoncai.springbootmybatisplus.entity;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTest {

    /**
     * ActiveRecord操作
     */

    @Test
    public void insert(){
        Employee employee = new Employee();
        employee.setLastName("小张");
        employee.setAge(12);
        employee.setGender("1");
        employee.setEmail("76@163.com");
        employee.insert();
    }

    @Test
    public void update(){
        Employee employee = new Employee().selectById(13);
        employee.setLastName("小王");
        employee.updateById();
        System.out.println(employee);
    }

    @Test
    public void updateById(){
        Employee employee = new Employee().selectById(13);
        System.out.println(employee);
        Employee employee1 = new Employee();
        employee1.setId(13);
        Employee employee2 = employee1.selectById();
        System.out.println(employee2);

    }

    @Test
    public void selectAll(){
        List<Employee> employees = new Employee().selectAll();
        System.out.println(employees);
    }

    @Test
    public void selectList(){
        List<Employee> employees = new Employee().selectList(new QueryWrapper<Employee>().like("last_name", "lang"));
        System.out.println(employees);
    }

    @Test
    public void selectCount(){
        Integer count = new Employee().selectCount((new QueryWrapper<Employee>().like("last_name", "lang")));
        System.out.println(count);
    }

    @Test
    public void deleteById(){
        //删除不存在的数据逻辑上也是true
        boolean result = new Employee().deleteById(5);
        System.out.println(result);
    }
    @Test
    public void delete(){
        Employee employee = new Employee();
        boolean result = employee.delete(new QueryWrapper<Employee>().like("last_name", "da"));
        System.out.println(result);
    }

    @Test
    public void page(){
        Employee employee = new Employee();
        IPage<Employee> employeeIPage = employee.selectPage(new Page<>(1, 1), new QueryWrapper<Employee>().like("last_name", "xiao"));
        System.out.println(employeeIPage.getRecords());
    }

}