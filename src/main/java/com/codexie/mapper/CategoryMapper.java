package com.codexie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codexie.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
