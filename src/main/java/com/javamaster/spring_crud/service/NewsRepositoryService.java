package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.model.News;

import java.util.List;

public interface NewsRepositoryService {

    List<News> getAll();
}
