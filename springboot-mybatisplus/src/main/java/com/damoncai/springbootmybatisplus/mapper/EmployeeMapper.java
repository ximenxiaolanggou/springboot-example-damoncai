package com.damoncai.springbootmybatisplus.mapper;

import com.damoncai.springbootmybatisplus.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author damoncai
 * @since 2019-05-18
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

    public List<Employee> findAll();
}
