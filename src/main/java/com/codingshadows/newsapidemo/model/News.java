package com.codingshadows.newsapidemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.AttributeAccessor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
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
