package com.concretepage.dao;

import com.concretepage.config.HibernateUtil;
import com.concretepage.entity.Person;
import java.util.ArrayList;
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
        //StringBuilder hql = new StringBuilder();
        //hql.append("(select p, s from Person as p left outer join p.shirts as s)");
        //hql.append(" union all ");
        //hql.append("(select p2, s2 from Person as p2 left outer join p2.shirtsb as s2)");
        //String hql = "from Person as p inner join p.shirts as s";
        //String hql = "select e from Shirt e inner join e.person";
        //String hql = "from Company as comp inner join comp.employees as emp";        
        //String hql = "from Company as comp left outer join comp.employees as emp";        
        
        StatelessSession statelessSession = mysqlSrv.getSessionFactory().openStatelessSession();

        List<?> resultSet;
        resultSet = new ArrayList();

        String hql1 = "from Person as p left outer join p.shirts as s";
        Query query1 = statelessSession.createQuery(hql1);
        resultSet.addAll(query1.list());

        String hql2 = "from Person as p2 left outer join p2.shirtsb as s2";
        Query query2 = statelessSession.createQuery(hql2);
        resultSet.addAll(query2.list());

        return resultSet;
    }

}
