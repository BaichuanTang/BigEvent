package com.itheima.bigevent.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.bigevent.mapper.ArticleMapper;
import com.itheima.bigevent.pojo.Article;
import com.itheima.bigevent.pojo.PageBean;
import com.itheima.bigevent.service.ArticleService;
import com.itheima.bigevent.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void add(final Article article) {
        // Add attributes
        final Map<String, Object> map = ThreadLocalUtil.get();
        final Integer id = (Integer) map.get("id");
        article.setCreateUser(id);
        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(final Integer pageNum, final Integer pageSize, final Integer categoryId, final String state) {
        final PageBean<Article> pageBean = new PageBean<>();
        PageHelper.startPage(pageNum, pageSize);
        final Map<String, Object> map = ThreadLocalUtil.get();
        final Integer id = (Integer) map.get("id");
        final Page<Article> articleList = (Page<Article>) articleMapper.list(id, categoryId, state);
        pageBean.setTotal(articleList.getTotal());
        pageBean.setItems(articleList.getResult());
        return pageBean;
    }


    @Override
    public Article findById(final Integer id) {

        return articleMapper.findById(id);
    }

    @Override
    public void update(final Article article) {
        articleMapper.update(article);
    }

    @Override
    public void delete(final Integer id) {
        articleMapper.delete(id);
    }
}
