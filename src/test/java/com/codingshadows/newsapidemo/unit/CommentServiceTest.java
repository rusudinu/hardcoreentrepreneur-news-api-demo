package com.codingshadows.newsapidemo.unit;

import com.codingshadows.newsapidemo.model.Comment;
import com.codingshadows.newsapidemo.service.CommentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CommentServiceTest {
    @Autowired
    private CommentService commentService;

    @Test
    public void whenGenerateComments_thenVerifyTheyExist() {
        List<Comment> comments = commentService.generateCommentList(100);
        Assertions.assertNotNull(comments);
        assert comments.size() > 0;
    }
}
