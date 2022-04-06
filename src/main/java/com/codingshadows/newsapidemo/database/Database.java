package com.codingshadows.newsapidemo.database;

import com.codingshadows.newsapidemo.model.News;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class Database {
    private final static List<News> NEWS_TABLE = new ArrayList<>();

    public static void add(News news) {
        NEWS_TABLE.add(news);
    }

    public static void addAll(List<News> news) {
        NEWS_TABLE.addAll(news);
    }

    public static void remove(News news) {
        NEWS_TABLE.remove(news);
    }

    public static void remove(UUID id) {
        for (News news : NEWS_TABLE) {
            if (news.getId().equals(id)) {
                NEWS_TABLE.remove(news);
                break;
            }
        }
    }

    public static List<News> getAll() {
        return NEWS_TABLE;
    }

    public static void removeAll() {
        NEWS_TABLE.clear();
    }

    public static List<News> getByAuthorId(UUID id) {
        return NEWS_TABLE.stream().filter(news -> news.getAuthor().getId().equals(id)).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static News get(UUID id) {
        return NEWS_TABLE.stream().filter(news -> news.getId().equals(id)).findFirst().orElse(null);
    }
}
