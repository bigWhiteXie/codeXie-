package com.codexie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.codexie.common.R;
import com.codexie.pojo.Employee;
import com.codexie.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("login")
    public R<Employee> login(@RequestBody Employee employee, HttpSession session){
        R<Employee> r = employeeService.loginService(employee,session);
        return r;
    }

    @PostMapping("logout")
    public R logout(HttpSession session){
        session.invalidate();

        return R.success("退出成功");
    }

    @GetMapping("page")
    public R page(Integer page, Integer pageSize, @RequestParam(required = false) String name){
        return R.success(employeeService.getPage(page,pageSize,name));
    }

    @PostMapping()
    public R save(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("{id}")
    public R employeeInfo(@PathVariable("id") String id){
        Employee employee = employeeService.getById(id);
        if(employee == null){
            return R.error("该用户不存在");
        }
        return R.success(employee);
    }


    @PutMapping()
    public R editEmployee(@RequestBody Employee employee){
        boolean save = employeeService.save(employee);
        return save?R.success("修改成功"):R.error("修改失败");
    }



}
