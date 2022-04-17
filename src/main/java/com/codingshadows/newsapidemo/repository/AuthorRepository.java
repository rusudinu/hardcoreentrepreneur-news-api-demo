package com.codingshadows.newsapidemo.repository;

import com.codingshadows.newsapidemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}

