package com.codexie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.codexie.mapper.OrderDetailMapper;
import com.codexie.pojo.OrderDetail;
import com.codexie.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}