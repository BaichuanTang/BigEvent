package com.itheima.controller;

import com.itheima.pojo.Article;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/article")
@CrossOrigin//支持跨域
public class ArticleController {

    private List<Article> articleList = new ArrayList<>();

    {
        articleList.add(new Article("医疗反腐绝非砍医护收入", "时事", "2023-09-5", "已发布"));
        articleList.add(new Article("中国男篮缘何一败涂地", "篮球", "2023-09-5", "草稿"));
        articleList.add(new Article("华山景区已受大风影响阵风达7-8级", "旅游", "2023-09-5", "已发布"));
    }

    //新增文章
    @PostMapping("/add")
    public String add(@RequestBody Article article) {
        articleList.add(article);
        return "新增成功";
    }

    //获取所有文章信息
    @GetMapping("/getAll")
    public List<Article> getAll(HttpServletResponse response) {
        return articleList;
    }

    //根据文章分类和发布状态搜索
    @GetMapping("/search")
    public List<Article> search(String category, String state) {
        return articleList.stream().filter(a -> a.getCategory().equals(category) && a.getState().equals(state)).collect(Collectors.toList());
    }
}
