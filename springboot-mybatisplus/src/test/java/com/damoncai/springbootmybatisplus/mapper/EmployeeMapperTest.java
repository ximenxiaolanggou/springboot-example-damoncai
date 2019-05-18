package com.damoncai.springbootmybatisplus.mapper;

import com.alibaba.druid.stat.TableStat;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.damoncai.springbootmybatisplus.entity.Employee;
import com.mysql.cj.x.protobuf.MysqlxExpect;
import org.apache.catalina.valves.rewrite.RewriteCond;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Condition;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void findAll(){
        List<Employee> list = employeeMapper.findAll();
        System.out.println(list);
    }

    @Test
    public void insert(){
        Employee employee = new Employee();
        employee.setLastName("xiaolang");
        employee.setEmail("123@qq.com");
        employee.setGender("1");
        employee.setAge(20);
//        employee.setMoney(20000.00);
        Integer result = employeeMapper.insert(employee);
        System.out.println("result:" + result);
        System.out.println("刚插入数据的主键是:" + employee.getId());
    }
    @Test
    public void update(){
        Employee employee = employeeMapper.selectById(10);
        employee.setLastName("Husky");
        employee.setAge(null);
        employeeMapper.updateById(employee);
    }
    @Test
    public void selectOne(){
        Employee employee = new Employee();
        employee.setLastName("Husky");
        employee.setAge(11);
    }
    @Test
    public void selectByIds(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        List employeeList = employeeMapper.selectBatchIds(list);
        System.out.println(employeeList);
    }

    @Test
    public void selectByMap(){
        //String 类型为表的列名
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("last_name", "Husky");
        List employeeList = employeeMapper.selectByMap(columnMap);
        System.out.println(employeeList);
    }
    @Test
    public void page(){
        IPage<Employee> employeeIPage = employeeMapper.selectPage(new Page<>(1, 1), null);
        long current = employeeIPage.getCurrent();
        long pages = employeeIPage.getPages();
        List<Employee> records = employeeIPage.getRecords();
        long size = employeeIPage.getSize();
        long total = employeeIPage.getTotal();
        System.out.println("current:" + current);
        System.out.println("pages:" + pages);
        System.out.println("records:" + records);
        System.out.println("size:" + size);
        System.out.println("total:" + total);
    }

    @Test
    public void deleteById(){
        //String 类型为表的列名
        int result = employeeMapper.deleteById(10);
        System.out.println("result:" + result);
    }

    @Test
    public void deleteByIds() {
        //String 类型为表的列名
        List list = new ArrayList();
        list.add(7);
        list.add(8);
        list.add(9);
        employeeMapper.deleteBatchIds(list);
    }

    @Test
    public void deleteByMap(){
        //String 类型为表的列名
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("last_name", "xiaolang");
        columnMap.put("age", 20);
        int result = employeeMapper.deleteByMap(columnMap);
        System.out.println("result:" + result);
    }

    /**
     * 条件构造器 查询操作
     * 注意：操作的都是数据库列名
     */
    @Test
    public void entityWrapperSelect() {
        Wrapper<Employee> wrapper =
                new QueryWrapper<Employee>()
                .between("age", 100, 300)
                .eq("last_name", "xiaolang");
        IPage<Employee> employeeIPage = employeeMapper.selectPage(new Page<Employee>(1, 2), wrapper);
        System.out.println(employeeIPage);
    }

    @Test
    public void selectList() {
        List<Employee> employees = employeeMapper.selectList(new QueryWrapper<Employee>()
                .like("last_name", "o")
                .eq("age", 26)
                .or()  // (last_name like '%o%' AND age = 26 OR last_name = 'Husky')
                .eq("last_name", "Husky")
        );
        System.out.println(employees);
    }

    @Test
    public void updateWrapper() {
        Employee employee = employeeMapper.selectById(12);
        employee.setAge(100);
        employeeMapper.update(employee, new UpdateWrapper<Employee>()
                        .like("last_name", "sky")
                        );
    }

    @Test
    public void delete() {
        employeeMapper.delete(new QueryWrapper<Employee>()
                .eq("last_name", "xiaolang")
                .like("email", "qq"));
    }

    @Test
    public void orderBy() {
        List<Employee> employees = employeeMapper.selectList(new QueryWrapper<Employee>().orderByDesc("id"));
        System.out.println(employees);
    }

    @Test
    public void condition() {
    }
}