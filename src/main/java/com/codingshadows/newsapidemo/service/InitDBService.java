package com.codingshadows.newsapidemo.service;

import com.codingshadows.newsapidemo.database.Database;
import com.codingshadows.newsapidemo.model.Author;
import com.codingshadows.newsapidemo.model.News;
import com.thedeanda.lorem.LoremIpsum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public final class InitDBService {
    private static final int COMMENTS_UPPER_BOUND = 10;
    private static final int PARAGRAPHS_UPPER_BOUND = 10;
    private static final int NUMBER_OF_NEWS = 100;

    private final NewsGeneratorService newsGeneratorService;

    public List<News> init() {
        for (int i = 0; i < NUMBER_OF_NEWS; ++i) {
            Database.add(newsGeneratorService.generateNews(COMMENTS_UPPER_BOUND, PARAGRAPHS_UPPER_BOUND));
        }
        return Database.getAll();
    }
}
