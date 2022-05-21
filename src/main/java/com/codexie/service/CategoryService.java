package com.codexie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.codexie.pojo.Category;

public interface CategoryService extends IService<Category> {

    public void remove(Long id);

}
