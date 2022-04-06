package com.codingshadows.newsapidemo.service;

import com.codingshadows.newsapidemo.database.Database;
import com.codingshadows.newsapidemo.model.News;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NewsService {
    public List<News> getAll() {
        return Database.getAll();
    }

    public void add(News news) {
        Database.add(news);
    }

    public void addAll(List<News> news) {
        Database.addAll(news);
    }

    public void remove(News news) {
        Database.remove(news);
    }

    public void remove(UUID id) {
        Database.remove(id);
    }

    public void removeAll() {
        Database.removeAll();
    }

    public List<News> getByAuthorId(UUID id) {
        return Database.getByAuthorId(id);
    }

    public News get(UUID id) {
        return Database.get(id);
    }
}
