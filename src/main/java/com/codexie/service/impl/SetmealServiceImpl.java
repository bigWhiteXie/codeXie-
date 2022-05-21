package com.codexie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.codexie.dto.SetmealDto;
import com.codexie.mapper.SetmealMapper;
import com.codexie.pojo.Setmeal;
import com.codexie.service.SetmealDishService;
import com.codexie.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {

    @Autowired
    private SetmealDishService setmealDishService;


    @Override
    public void saveWithDish(SetmealDto setmealDto) {

    }

    @Override
    public void removeWithDish(List<Long> ids) {

    }
}
