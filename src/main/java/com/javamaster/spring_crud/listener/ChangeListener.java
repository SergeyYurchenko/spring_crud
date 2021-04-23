package com.javamaster.spring_crud.listener;

import com.javamaster.spring_crud.model.Comment;
import com.javamaster.spring_crud.model.News;
import com.javamaster.spring_crud.model.NewsSetting;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * Слушатель изменения всех сущностей
 * @author s.yurchenko
 */
public class ChangeListener {

    @PrePersist
    public void preCreate(News news){
        news.setDateCreate(new Date());
    }

    @PreUpdate
    public void preUpdate(News news){
        news.setDateModification(new Date());
    }

    @PrePersist
    public void preCreate(Comment comment){
        comment.setDateCreate(new Date());
    }


    @PrePersist
    public void preCreate(NewsSetting newsSetting){
        newsSetting.setDateCreate(new Date());
    }

    @PreUpdate
    public void preUpdate(NewsSetting newsSetting){
    newsSetting.setDateModification(new Date());
    }
}
