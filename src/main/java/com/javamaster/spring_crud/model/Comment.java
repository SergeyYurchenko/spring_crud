package com.javamaster.spring_crud.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "news_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_generator")
    @SequenceGenerator(name = "comment_generator", sequenceName = "general_news_comment_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "news_id")
    private News news;

    @Column(name = "comment")
    private String comment;

    @Column(name = "author_login")
    private String authorLogin;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "DATE_CREATE")
    private Date dateCreate;
}
