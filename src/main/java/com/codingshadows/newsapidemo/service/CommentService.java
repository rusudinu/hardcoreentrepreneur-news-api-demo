package com.codingshadows.newsapidemo.service;

import com.codingshadows.newsapidemo.model.Comment;
import com.codingshadows.newsapidemo.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final NewsGeneratorService newsGeneratorService;
    private final AuthorService authorService;

    public List<Comment> generateCommentList(int commentsUpperBound) {
        List<Comment> comments = new ArrayList<>();
        int numComments = new Random().nextInt(commentsUpperBound);
        for (int i = 0; i < numComments; ++i) {
            comments.add(commentRepository.save(newsGeneratorService.generateComment(authorService.getRandomAuthor())));
        }
        return comments;
    }
}
