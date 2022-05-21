package com.codexie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.codexie.mapper.UserMapper;
import com.codexie.pojo.User;
import com.codexie.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
