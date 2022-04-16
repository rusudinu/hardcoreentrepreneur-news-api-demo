package com.codingshadows.newsapidemo.controller;

import com.codingshadows.newsapidemo.facade.InitializeDatabaseFacade;
import com.codingshadows.newsapidemo.model.News;
import com.codingshadows.newsapidemo.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
