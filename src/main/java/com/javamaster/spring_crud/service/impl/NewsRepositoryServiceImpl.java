package com.javamaster.spring_crud.service.impl;

import com.javamaster.spring_crud.model.News;
import com.javamaster.spring_crud.repository.NewsRepository;
import com.javamaster.spring_crud.service.NewsRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsRepositoryServiceImpl implements NewsRepositoryService {

    private final NewsRepository repository;

    @Autowired
    public NewsRepositoryServiceImpl(NewsRepository newsRepository){
        this.repository = newsRepository;
    }

    @Override
    public List<News> getAll(){
       return repository.findAll();
    }
}
