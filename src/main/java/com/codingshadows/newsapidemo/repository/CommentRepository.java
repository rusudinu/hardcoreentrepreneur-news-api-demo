package com.codingshadows.newsapidemo.repository;

import com.codingshadows.newsapidemo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

