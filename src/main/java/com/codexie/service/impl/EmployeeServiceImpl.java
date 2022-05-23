package com.codexie.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.codexie.common.BaseContext;
import com.codexie.common.R;
import com.codexie.mapper.EmployeeMapper;
import com.codexie.pojo.Employee;
import com.codexie.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public R<Employee> loginService(Employee employee, HttpSession session) {
        String pwd = DigestUtils.md5DigestAsHex(employee.getPassword().getBytes());
        Employee one = lambdaQuery().eq(Employee::getUsername, employee.getUsername()).eq(Employee::getPassword, pwd).one();
        if(one == null){
            return R.error("账号或密码错误");
        }

        if(one.getStatus() != 1){
            return R.error("该账号已经禁用");
        }
        session.setAttribute("employee",one);
        BaseContext.setEmp(one);

        return R.success(one);
    }

    @Override
    public Page<Employee> getPage(Integer page, Integer pageSize, String name) {
        Page<Employee> currentPage = new Page<>(page, pageSize);
        Page<Employee> empPage = lambdaQuery().like(StrUtil.isNotBlank(name),Employee::getName,name).orderByDesc(Employee::getUpdateTime).page(currentPage);

        return empPage;
    }

    @Override
    public R addEmployee(Employee employee) {
        employee.setPassword("123456");
        boolean success = save(employee);
        if(success){
            return R.success("添加成功");
        }
        return R.error("添加失败");
    }
}
