package com.concretepage.dao;

import com.concretepage.config.HibernateUtil;
import com.concretepage.entity.Article;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.StatelessSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleSLDAO implements IArticleSLDAO {

    @Autowired
    private HibernateUtil mysqlSrv;

    @Override
    public void getAll() {
        StatelessSession statelessSession = mysqlSrv.getSessionFactory().openStatelessSession();
        Criteria c = statelessSession.createCriteria(Article.class);

        ScrollableResults itemCursor = c.scroll();

        while (itemCursor.next()) {
            System.out.println((Article) itemCursor.get(0));
        }
        itemCursor.close();

    }

    @Override
    public List<Article> getAllArticles() {
        String hql = "FROM Article as atcl ORDER BY atcl.articleId";
        StatelessSession statelessSession = mysqlSrv.getSessionFactory().openStatelessSession();        
        Query query = statelessSession.createQuery(hql);
        return query.list();
    }


            
}
