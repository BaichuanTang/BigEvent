package com.itheima.bigevent.service;

import com.itheima.bigevent.pojo.Category;

import java.util.List;

public interface CategoryService {

    void add(final Category category);

    List<Category> list();

    Category findById(final Integer id);

    void update(final Category category);

    void delete(final Integer id);
}
