package com.codingshadows.newsapidemo.service;

import com.codingshadows.newsapidemo.model.Author;
import com.codingshadows.newsapidemo.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final NewsGeneratorService newsGeneratorService;

    public void generateAuthors(int numberOfNews) {
        for (int i = 0; i < numberOfNews; ++i) {
            authorRepository.save(newsGeneratorService.generateAuthor());
        }
    }

    public Author getRandomAuthor() {
        long size = authorRepository.count();
        int index = (int) (Math.random() * size);
        Page<Author> questionPage = authorRepository.findAll(PageRequest.of(index, 1));
        Author author = null;
        if (questionPage.hasContent()) {
            author = questionPage.getContent().get(0);
        }
        return author;
    }
}
