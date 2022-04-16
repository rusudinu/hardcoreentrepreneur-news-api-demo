package com.codingshadows.newsapidemo.repository;

import com.codingshadows.newsapidemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
