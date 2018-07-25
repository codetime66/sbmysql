package com.concretepage.dao;

import com.concretepage.config.HibernateUtil;
import com.concretepage.entity.Person;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.StatelessSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAO implements IPersonDAO {

    @Autowired
    private HibernateUtil mysqlSrv;

    @Override
    public List<Person> getAllPersons() {
        String hql = "FROM Person as p ORDER BY p.id";
        StatelessSession statelessSession = mysqlSrv.getSessionFactory().openStatelessSession();        
        Query query = statelessSession.createQuery(hql);
        return query.list();
    }

    //public List<Person> getPersonShirts() {    
    @Override
    public List<?> getPersonShirts() {        
        String hql = "from Person as p left outer join p.shirts as s";
        //String hql = "from Person as p inner join p.shirts as s";
        //String hql = "select e from Shirt e inner join e.person";
        //String hql = "from Company as comp inner join comp.employees as emp";        
        //String hql = "from Company as comp left outer join comp.employees as emp";        
        StatelessSession statelessSession = mysqlSrv.getSessionFactory().openStatelessSession();        
        Query query = statelessSession.createQuery(hql);
        return query.list();
    }
    
}
