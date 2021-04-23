package com.javamaster.spring_crud.model;

import com.javamaster.spring_crud.enums.Source;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@ToString
@Table(name = "itsm_news")
public class News extends ParentSettings{

    @Setter
    @Column(name = "source")
    private Source source;


    @Setter
    @Column(name = "modifier_login")
    private String modifierLogin;

    @Setter
    @Column(name = "modifier_name")
    private String modifierName;


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
