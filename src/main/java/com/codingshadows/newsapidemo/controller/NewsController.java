package com.codingshadows.newsapidemo.controller;

import com.codingshadows.newsapidemo.facade.InitializeDatabaseFacade;
import com.codingshadows.newsapidemo.model.News;
import com.codingshadows.newsapidemo.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.management.DescriptorKey;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/news")
@RequiredArgsConstructor
public class NewsController {
    private final InitializeDatabaseFacade initializeDatabaseFacade;
    private final NewsService newsService;


    @GetMapping("generate")
    public List<News> generateNews() {
        return initializeDatabaseFacade.generateNews();
    }

    @GetMapping("all")
    public List<News> getAll() {
        return newsService.getAll();
    }

    @PostMapping("add")
    public News add(News news) {
        return newsService.add(news);
    }

    @PostMapping("add-all")
    public List<News> addAll(List<News> news) {
        return newsService.addAll(news);
    }

    @DeleteMapping("remove/{id}")
    public void remove(@PathVariable Long id) {
        newsService.remove(id);
    }

    @DeleteMapping("remove-all")
    public void removeAll() {
        newsService.removeAll();
    }

    @GetMapping("{id}")
    public News getById(@PathVariable Long id) {
        return newsService.get(id);
    }

    @GetMapping("by-author/{id}")
    public List<News> getByAuthorId(@PathVariable Long id) {
        return newsService.getByAuthorId(id);
    }
}
