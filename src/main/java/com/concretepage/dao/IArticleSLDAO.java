package com.concretepage.dao;

import com.concretepage.entity.Article;
import java.util.List;

public interface IArticleSLDAO {

    void getAll();
    
    List<Article> getAllArticles();
}
