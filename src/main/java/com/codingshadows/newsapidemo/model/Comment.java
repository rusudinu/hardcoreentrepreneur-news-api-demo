package com.codingshadows.newsapidemo.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public final class Comment {
    private final UUID id;
    private final Author author;
    private final String body;
}
