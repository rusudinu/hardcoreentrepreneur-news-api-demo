package com.codingshadows.newsapidemo.unit;

import com.codingshadows.newsapidemo.model.Author;
import com.codingshadows.newsapidemo.service.AuthorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthorServiceTest {
    @Autowired
    private AuthorService authorService;

    @Test
    public void whenGenerateAuthors_thenSelectAuthorAtRandom() {
        authorService.generateAuthors(100);
        Author author = authorService.getRandomAuthor();
        Assertions.assertNotNull(author);
        Assertions.assertNotNull(author.getId());
        Assertions.assertNotNull(author.getName());
        Assertions.assertNotNull(author.getDescription());
    }
}
