package com.codexie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.codexie.common.R;
import com.codexie.pojo.Employee;

import javax.servlet.http.HttpSession;

public interface EmployeeService extends IService<Employee> {
    R<Employee> loginService(Employee employee, HttpSession session);

    Page<Employee> getPage(Integer page, Integer pageSize,String name);

    R addEmployee(Employee employee);
}
