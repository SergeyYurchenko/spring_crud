package com.javamaster.spring_crud.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import java.util.Date;

@Entity
@Getter
@EqualsAndHashCode
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ParentSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "news_generator")
    @SequenceGenerator(name = "news_generator", sequenceName = "general_news_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Setter
    @Column(name = "date_create")
    private Date dateCreate;

    @Setter
    @Column(name = "author_login")
    private String authorLogin;

    @Setter
    @Column(name = "author_name")
    private String authorName;
}
