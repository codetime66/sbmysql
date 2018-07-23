package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.IArticleSLDAO;
import com.concretepage.entity.Article;

@Service
public class ArticleSLService implements IArticleSLService {
    
	@Autowired
	private IArticleSLDAO articleSLDAO;

	@Override
	public List<Article> getAllArticles(){
		return articleSLDAO.getAllArticles();
	}
        
        @Override
        public void getAll(){
            articleSLDAO.getAll();
        }
}
