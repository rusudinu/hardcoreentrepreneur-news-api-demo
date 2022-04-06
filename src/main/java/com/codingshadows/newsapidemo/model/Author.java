package com.codingshadows.newsapidemo.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public final class Author {
    private final UUID id;
    private final String name;
    private final String description;
}
