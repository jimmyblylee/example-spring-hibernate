/**
 * Project Name : hibernate <br>
 * File Name : Service.java <br>
 * Package Name : com.lee.example.h <br>
 * Create Time : Sep 9, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.h;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lee.example.h.entity.Group;
import com.lee.example.h.entity.User;

/**
 * ClassName : Service <br>
 * Description : service for getting info in database <br>
 * Create Time : Sep 9, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 *
 */
public class Service {

    private SessionFactory factory;
    private Session session;
    
    public Service() {
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        session = factory.openSession();
    }
    
    @SuppressWarnings("unchecked")
    public List<Group> getAllGroups() {
        return session.createQuery("from Group").list();
    }
    
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return session.createQuery("from User").list();
    }
    
    public void close() {
        if (session != null) {
            session.disconnect();
            session.close();
        }
        if (factory != null) {
            factory.close();
        }
    }
}
