package com.codingshadows.newsapidemo.service;

import com.thedeanda.lorem.LoremIpsum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class NewsGeneratorService {

    public News generateNews(Author author, List<Comment> comments, int paragraphsUpperBound) {
        return News.builder().author(author).title(generateNewsTitle()).body(generateBody(paragraphsUpperBound)).comments(comments).build();
    }

    private List<String> generateBody(int paragraphsUpperBound) {
        List<String> body = new ArrayList<>();
        int paragraphs = new Random().nextInt(paragraphsUpperBound);
        for (int i = 0; i < paragraphs; ++i) {
            body.add(generateNewsParagraph());
        }
        return body;
    }

    public Comment generateComment(Author author) {
        return Comment.builder().author(author).body(generateCommentBody()).build();
    }

    public Author generateAuthor() {
        return Author.builder().name(generateAuthorName()).description(generateAuthorDescription()).build();
    }

    private String generateAuthorName() {
        return LoremIpsum.getInstance().getWords(1, 3);
    }

    private String generateAuthorDescription() {
        return LoremIpsum.getInstance().getWords(60, 80);
    }

    private String generateCommentBody() {
        return LoremIpsum.getInstance().getWords(50, 100);
    }

    private String generateNewsTitle() {
        return LoremIpsum.getInstance().getWords(3, 6);
    }

    private String generateNewsParagraph() {
        return LoremIpsum.getInstance().getWords(300, 500);
    }
}
