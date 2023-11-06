package com.itheima.bigevent.service;

import com.itheima.bigevent.pojo.Article;
import com.itheima.bigevent.pojo.PageBean;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ArticleService {

    void add(final Article article);

    PageBean<Article> list(final Integer pageNum,
                           final Integer pageSize,
                           final Integer categoryId,
                           final String state);

    Article findById(final Integer id);

    void update(final Article article);

    void delete(Integer id);
}
