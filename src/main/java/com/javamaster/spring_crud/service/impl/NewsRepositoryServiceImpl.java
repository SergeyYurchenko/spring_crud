package com.javamaster.spring_crud.service.impl;

import com.javamaster.spring_crud.model.News;
import com.javamaster.spring_crud.model.NewsSetting;
import com.javamaster.spring_crud.repository.NewsRepository;
import com.javamaster.spring_crud.repository.NewsSettingRepository;
import com.javamaster.spring_crud.service.NewsRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@Service
public class NewsRepositoryServiceImpl implements NewsRepositoryService {

    private final NewsRepository newsRepository;

    private final NewsSettingRepository newsSettingRepository;

    @Autowired
    public NewsRepositoryServiceImpl(NewsRepository newsRepository, NewsSettingRepository newsSettingRepository) {
        this.newsRepository = newsRepository;
        this.newsSettingRepository = newsSettingRepository;
    }

    @Override
    public List<News> getActiveNews(Boolean status) {
        return newsRepository.findByStatus(status);
    }

    @Override
    @Transient
    public void addNews(News news) {
        newsRepository.save(news);
    }

    @Override
    public List<NewsSetting> getAllSettings(){
       return newsSettingRepository.findAll();
    }

    @Override
    @Transient
    public void addSettings(NewsSetting setting) {
        newsSettingRepository.save(setting);

    }
}
