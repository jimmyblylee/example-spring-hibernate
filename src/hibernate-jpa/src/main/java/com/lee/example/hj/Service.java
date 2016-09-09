/**
 * Project Name : example-hibernate-jpa <br>
 * File Name : Service.java <br>
 * Package Name : com.lee.example.hj <br>
 * Create Time : Sep 9, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.hj;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

    private EntityManagerFactory factory;
    private EntityManager em;
    
    
    public Service() {
        factory = Persistence.createEntityManagerFactory("data_mgmt");
        em = factory.createEntityManager();
    }
    
    @SuppressWarnings("unchecked")
    public List<Group> getAllGroups() {
        return em.createQuery("from Group").getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return em.createQuery("from User").getResultList();
    }
    
    public void close() {
        if (em != null) {
            em.close();
        }
        if (factory != null) {
            factory.close();
        }
    }
}
