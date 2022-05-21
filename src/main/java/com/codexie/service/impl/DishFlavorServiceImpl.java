package com.codexie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.codexie.mapper.DishFlavorMapper;
import com.codexie.pojo.DishFlavor;
import com.codexie.service.DishFlavorService;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
