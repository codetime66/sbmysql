package com.concretepage.config;

import javax.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class HibernateUtil {

    private SessionFactory hibernateFactory;

    public HibernateUtil(EntityManagerFactory factory) {
        if (factory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.hibernateFactory = factory.unwrap(SessionFactory.class);
    }
    
    public SessionFactory getSessionFactory(){
        return hibernateFactory;
    }
}
