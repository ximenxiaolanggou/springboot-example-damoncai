package com.damoncai.springbootmybatisplus.service.impl;

import com.damoncai.springbootmybatisplus.entity.Employee;
import com.damoncai.springbootmybatisplus.mapper.EmployeeMapper;
import com.damoncai.springbootmybatisplus.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author damoncai
 * @since 2019-05-18
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
