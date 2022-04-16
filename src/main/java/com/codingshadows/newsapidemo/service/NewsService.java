package com.codingshadows.newsapidemo.service;

import com.codingshadows.newsapidemo.model.News;
import com.codingshadows.newsapidemo.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final NewsRepository newsRepository;

    public List<News> getAll() {
        return newsRepository.findAll();
    }

    public News add(News news) {
        return newsRepository.save(news);
    }

    public List<News> addAll(List<News> news) {
        return newsRepository.saveAll(news);
    }

    public void remove(Long id) {
        newsRepository.deleteById(id);
    }

    public void removeAll() {
        newsRepository.deleteAll();
    }

    public List<News> getByAuthorId(Long id) {
        return newsRepository.findAllByAuthorId(id);
    }

    public News get(Long id) {
        return newsRepository.findById(id).orElseThrow();
    }
}
