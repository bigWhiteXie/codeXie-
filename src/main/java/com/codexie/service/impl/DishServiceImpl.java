package com.codexie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.codexie.dto.DishDto;
import com.codexie.mapper.DishMapper;
import com.codexie.pojo.Dish;
import com.codexie.service.DishFlavorService;
import com.codexie.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

    @Autowired
    private DishFlavorService dishFlavorService;


    @Override
    public void saveWithFlavor(DishDto dishDto) {

    }

    @Override
    public DishDto getByIdWithFlavor(Long id) {
        return null;
    }

    @Override
    public void updateWithFlavor(DishDto dishDto) {

    }
}
