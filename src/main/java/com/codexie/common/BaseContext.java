package com.codexie.common;

import com.codexie.pojo.Employee;
import com.codexie.pojo.User;

/**
 * 基于ThreadLocal封装工具类，用户保存和获取当前登录用户id
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    private static ThreadLocal<Employee> empLocal = new ThreadLocal<>();
    private static ThreadLocal<User> userLocal = new ThreadLocal<>();

    /**
     * 设置值
     * @param id
     */
    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    public static void setEmp(Employee e){ empLocal.set(e); }

    public static void setUser(User u){ userLocal.set(u); }



    /**
     * 获取值
     * @return
     */
    public static Long getCurrentId(){
        return threadLocal.get();
    }

    public static Employee getCurrentEmp() { return empLocal.get();}
    public static User getCurrentUser() { return userLocal.get();}
}