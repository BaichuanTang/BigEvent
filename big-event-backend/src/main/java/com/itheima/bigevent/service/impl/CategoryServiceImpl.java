package com.itheima.bigevent.service.impl;

import com.itheima.bigevent.mapper.CategoryMapper;
import com.itheima.bigevent.pojo.Category;
import com.itheima.bigevent.service.CategoryService;
import com.itheima.bigevent.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void add(final Category category) {
        // Add attributes
        final Map<String, Object> map = ThreadLocalUtil.get();
        final Integer id = (Integer) map.get("id");
        category.setCreateUser(id);
        categoryMapper.add(category);
    }

    @Override
    public List<Category> list() {
        final Map<String, Object> map = ThreadLocalUtil.get();
        final Integer id = (Integer) map.get("id");

        return categoryMapper.list(id);
    }

    @Override
    public Category findById(final Integer id) {

        return categoryMapper.findById(id);
    }

    @Override
    public void update(final Category category) {
        categoryMapper.update(category);
    }

    @Override
    public void delete(final Integer id) {
        categoryMapper.delete(id);
    }
}
