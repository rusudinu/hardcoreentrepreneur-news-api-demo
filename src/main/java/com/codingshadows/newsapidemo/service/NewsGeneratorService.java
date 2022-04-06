package com.codingshadows.newsapidemo.service;

import com.codingshadows.newsapidemo.model.Author;
import com.codingshadows.newsapidemo.model.Comment;
import com.codingshadows.newsapidemo.model.News;
import com.thedeanda.lorem.LoremIpsum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class NewsGeneratorService {

    public News generateNews(int commentsUpperBound, int paragraphsUpperBound) {
        return News.builder().id(UUID.randomUUID()).author(generateAuthor()).title(generateNewsTitle()).body(generateBody(paragraphsUpperBound)).comments(generateComments(commentsUpperBound)).build();
    }

    private List<String> generateBody(int paragraphsUpperBound) {
        List<String> body = new ArrayList<>();
        int paragraphs = new Random().nextInt(paragraphsUpperBound);
        for (int i = 0; i < paragraphs; ++i) {
            body.add(generateNewsParagraph());
        }
        return body;
    }

    private List<Comment> generateComments(int commentsUpperBound) {
        List<Comment> comments = new ArrayList<>();
        int numComments = new Random().nextInt(commentsUpperBound);
        for (int i = 0; i < numComments; ++i) {
            comments.add(generateComment());
        }
        return comments;
    }

    private Comment generateComment() {
        return Comment.builder().id(UUID.randomUUID()).author(generateAuthor()).body(generateCommentBody()).build();
    }

    private Author generateAuthor() {
        return Author.builder().id(UUID.randomUUID()).name(generateAuthorName()).description(generateAuthorDescription()).build();
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
