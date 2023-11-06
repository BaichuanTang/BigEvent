package com.itheima.bigevent.controller;

import com.itheima.bigevent.pojo.Article;
import com.itheima.bigevent.pojo.PageBean;
import com.itheima.bigevent.pojo.Result;
import com.itheima.bigevent.service.ArticleService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
@Validated
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @PostMapping
    public Result<String> add(@RequestBody @Validated(Article.Add.class) Article article) {
        articleService.add(article);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<Article>> list(final Integer pageNum,
                                          final Integer pageSize,
                                          @RequestParam(required = false) final Integer categoryId,
                                          @RequestParam(required = false) final String state) {
        final PageBean<Article> articleList = articleService.list(pageNum, pageSize, categoryId, state);
        return Result.success(articleList);
    }

    @GetMapping("/detail")
    public Result<Article> detail(@NotNull final Integer id) {
        final Article article = articleService.findById(id);
        return Result.success(article);
    }


    @PutMapping
    public Result<String> update(@RequestBody @Validated(Article.Update.class) Article article) {
        articleService.update(article);
        return Result.success();
    }

    @DeleteMapping
    public Result<String> delete(@NotNull final Integer id) {
        articleService.delete(id);
        return Result.success();
    }
}
