package com.codexie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.codexie.common.BaseContext;
import com.codexie.common.R;
import com.codexie.mapper.EmployeeMapper;
import com.codexie.pojo.Employee;
import com.codexie.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public R<Employee> loginService(Employee employee, HttpSession session) {
        Employee one = lambdaQuery().eq(Employee::getName, employee.getName()).eq(Employee::getPassword, employee.getPassword()).one();
        if(one == null){
            return R.error("账号或密码错误");
        }

        if(one.getStatus() != 1){
            return R.error("该账号已经禁用");
        }
        session.setAttribute("employee",employee);
        BaseContext.setEmp(one);

        return R.success(one);
    }
}
