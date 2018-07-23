package com.concretepage.service;

import java.util.List;

import com.concretepage.entity.Article;

public interface IArticleSLService {
     List<Article> getAllArticles();
     void getAll();
}
