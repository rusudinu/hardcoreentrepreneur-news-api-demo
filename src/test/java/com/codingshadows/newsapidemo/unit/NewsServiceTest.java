package com.codingshadows.newsapidemo.unit;

import com.codingshadows.newsapidemo.facade.InitializeDatabaseFacade;
import com.codingshadows.newsapidemo.model.News;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class NewsServiceTest {
    @Autowired
    private InitializeDatabaseFacade initializeDatabaseFacade;

    @Test
    public void whenInitializeDatabase_thenMakeSureNewsExist() {
        List<News> news = initializeDatabaseFacade.generateNews();
        Assertions.assertNotNull(news);
        assert news.size() > 0;
    }
}
