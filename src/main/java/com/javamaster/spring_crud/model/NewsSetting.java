package com.javamaster.spring_crud.model;

import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "news_setting")
public class NewsSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "news_setting_generator")
    @SequenceGenerator(name = "news_setting_generator", sequenceName = "general_news_setting_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "setting_id")
    private List<News> news;

    @Setter
    @JoinColumn(name = "name")
    private String name;

    @Setter
    @JoinColumn(name = "parent_login")
    private String parentLogin;

    @Setter
    @JoinColumn(name = "position")
    private String position;

    @Setter
    @ElementCollection
    @CollectionTable(name = "news_setting_roles", joinColumns = @JoinColumn(name = "setting_id"))
    @Column(name = "roles")
    private List<String> roles = new ArrayList<>();


    @Column(name = "status")
    private Boolean status;
}
