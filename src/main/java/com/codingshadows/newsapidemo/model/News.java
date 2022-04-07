package com.codingshadows.newsapidemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Author author;
    @OneToMany
    private List<Comment> comments;
    private String title;
    @ElementCollection
    @Column(columnDefinition = "nvarchar(MAX)")
    private List<String> body;
}
