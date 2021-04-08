package com.javamaster.spring_crud.model;

import lombok.Data;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "itsm_news")
public class News {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long ind;

    private String authorLogin;

    private Long listWorkGroupOid;

    @ElementCollection
    @CollectionTable(name = "itsm_news_workGroups", joinColumns = @JoinColumn(name = "ind"))
    @Column(name = "workGroup_oid")
    private List<Long> itsm_workGroups;

//    @ManyToMany
//    @JoinTable( name = "itsm_workGroups",
//                joinColumns = { @JoinColumn(name = "ind") },
//                inverseJoinColumns = { @JoinColumn(name = "workGroup_id") }
//    )
//    private Set<News> workGroups = new HashSet<>();
}
