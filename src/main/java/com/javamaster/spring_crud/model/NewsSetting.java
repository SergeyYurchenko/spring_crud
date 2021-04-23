package com.javamaster.spring_crud.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Table(name = "news_setting")
public class NewsSetting extends ParentSettings{

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

    @Setter
    @Column(name = "status")
    private Boolean status;

    @Setter
    @Column(name = "date_modification")
    private Date dateModification;

    @Setter
    @Column(name = "modifier_login")
    private String modifierLogin;

    @Setter
    @Column(name = "modifier_name")
    private String modifierName;

}
