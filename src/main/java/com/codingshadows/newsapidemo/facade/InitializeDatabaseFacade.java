package com.codingshadows.newsapidemo.facade;

import com.codingshadows.newsapidemo.model.News;
import com.codingshadows.newsapidemo.repository.NewsRepository;
import com.codingshadows.newsapidemo.service.AuthorService;
import com.codingshadows.newsapidemo.service.CommentService;
import com.codingshadows.newsapidemo.service.NewsGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InitializeDatabaseFacade {
    private static final int COMMENTS_UPPER_BOUND = 10;
    private static final int PARAGRAPHS_UPPER_BOUND = 10;
    private static final int NUMBER_OF_NEWS = 100;

    private final NewsGeneratorService newsGeneratorService;
    private final NewsRepository newsRepository;
    private final AuthorService authorService;
    private final CommentService commentService;

    public List<News> generateNews() {
        authorService.generateAuthors(NUMBER_OF_NEWS);
        for (int i = 0; i < NUMBER_OF_NEWS; ++i) {
            newsRepository.save(newsGeneratorService.generateNews(authorService.getRandomAuthor(), commentService.generateCommentList(COMMENTS_UPPER_BOUND), PARAGRAPHS_UPPER_BOUND));
        }
        return newsRepository.findAll();
    }
}
