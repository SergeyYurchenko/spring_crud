package com.javamaster.spring_crud.api;

import com.javamaster.spring_crud.enums.Source;
import com.javamaster.spring_crud.model.Comment;
import com.javamaster.spring_crud.model.News;
import com.javamaster.spring_crud.model.NewsSetting;
import com.javamaster.spring_crud.service.NewsRepositoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class NewsController {

    private final NewsRepositoryService newsService;


    NewsController(NewsRepositoryService newsService){
        this.newsService = newsService;
    }


    @GetMapping(value = "/")
    public void getAll(){
        newsService.getActiveNews(true);
    }

    @GetMapping(value = "/add")
    public void create(){
        createNews();
    }

    private void createNews(){

        News news1 = new News();
        news1.setAuthorLogin("dn100395jsv");
        news1.setAuthorName("Юрченко Сергей Владимирович");
        news1.setDateCreate(new Date());
        news1.setDescription("Описание к активной новости. Новости 23");
        news1.setPublicationDate(new Date());
        news1.setEndingDate(new Date());
        news1.setSource(Source.ECO);
        news1.setStatus(true);
        news1.setInformation("Описание новости 23");
        List<Long> list= new ArrayList();
        list.add(12345L);
        list.add(123L);
        list.add(1234L);
        news1.setRecipientWorkGroups(list);
        createComment(news1);
        newsService.addNews(news1);
        createSettings();
    }

    private void createComment(News news){
        Comment comment1 = new Comment();
        comment1.setComment("Коментарий к новости");
        comment1.setAuthorLogin("dn100395jsv1");
        comment1.setAuthorName("Гагарин Юрий");
        comment1.setDateCreate(new Date());
        Comment comment2 = new Comment();
        comment2.setComment("Коментарий к новости2");
        comment2.setAuthorLogin("dn100395jsv2");
        comment2.setAuthorName("Гагарин Юрий Васильевич");
        comment2.setDateCreate(new Date());
        List<Comment> comments= new ArrayList();
        comments.add(comment1);
        comments.add(comment2);
        news.setComments(comments);
    }

    private void createSettings(){
        NewsSetting setting = new NewsSetting();
        setting.setName("Настройка номер 1");
        setting.setPosition("00018650");
        setting.setParentLogin("DN170R000000");
        newsService.addSettings(setting);
    };
}
