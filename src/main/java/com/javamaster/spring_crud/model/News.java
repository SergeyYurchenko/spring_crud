package com.javamaster.spring_crud.model;

import com.javamaster.spring_crud.enums.Source;
import lombok.*;


import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@EqualsAndHashCode
@ToString
@Table(name = "itsm_news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "news_generator")
    @SequenceGenerator(name = "news_generator", sequenceName = "general_news_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Setter
    @Column(name = "source")
    private Source source;

    @Setter
    @Column(name = "author_login")
    private String authorLogin;

    @Setter
    @Column(name = "modifier_login")
    private String modifierLogin;

    @Setter
    @Column(name = "author_name")
    private String authorName;

    @Setter
    @Column(name = "description")
    private String description;

    @Setter
    @Column(name = "information")
    private String information;

    @Setter
    @Column(name = "recommendation")
    private String recommendation;

    @Setter
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "news_work_groups", joinColumns = @JoinColumn(name = "news_id"))
    @Column(name = "workgroup_oid")
    private List<Long> recipientWorkGroups = new ArrayList<>();

    @Setter
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "news_id")
    private List<Comment> comments = new ArrayList<>();

    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "setting_id")
    private NewsSetting setting;

    @Setter
    @Column(name = "date_create")
    private Date dateCreate;

    @Setter
    @Column(name = "date_modification")
    private Date dateModification;

    @Setter
    @Column(name = "publication_date")
    private Date publicationDate;

    @Setter
    @Column(name = "end_date")
    private Date endingDate;

    @Setter
    @Column(name = "status")
    private Boolean status;
}
