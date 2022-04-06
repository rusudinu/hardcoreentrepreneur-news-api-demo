package com.codingshadows.newsapidemo.controller;

import com.codingshadows.newsapidemo.model.News;
import com.codingshadows.newsapidemo.service.InitDBService;
import com.codingshadows.newsapidemo.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/news")
@RequiredArgsConstructor
public class NewsController {
    private final InitDBService initDBService;
    private final NewsService newsService;

    @GetMapping("generate")
    public List<News> generateNews() {
        return initDBService.init();
    }

    @GetMapping("all")
    public List<News> getAll() {
        return newsService.getAll();
    }

    @PostMapping("add")
    public void add(News news) {
        newsService.add(news);
    }

    @PostMapping("add-all")
    public void addAll(List<News> news) {
        newsService.addAll(news);
    }

    @PostMapping("remove-by-obj")
    public void remove(News news) {
        newsService.remove(news.getId());
    }

    @PostMapping("remove")
    public void remove(UUID id) {
        System.out.println(id);
        newsService.remove(id);
    }

    @PostMapping("remove-all")
    public void removeAll() {
        newsService.removeAll();
    }

    @GetMapping("{id}")
    public News getById(@PathVariable UUID id) {
        return newsService.get(id);
    }

    @GetMapping("by-author/{id}")
    public List<News> getByAuthorId(@PathVariable UUID id) {
        return newsService.getByAuthorId(id);
    }
}
