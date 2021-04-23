package com.javamaster.spring_crud.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Getter
@ToString
@Table(name = "news_comment")
public class Comment extends ParentSettings {

    @ManyToOne
    @JoinColumn(name = "news_id")
    private News news;

    @Setter
    @Column(name = "comment")
    private String comment;



}
