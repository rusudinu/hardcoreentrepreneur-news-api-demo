package com.codingshadows.newsapidemo.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class News {
    private final UUID id;
    private final Author author;
    private final List<Comment> comments;
    private final String title;
    private final List<String> body;
}
