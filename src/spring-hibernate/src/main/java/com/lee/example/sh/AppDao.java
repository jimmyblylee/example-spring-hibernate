/**
 * Project Name : example-spring-hibernate <br>
 * File Name : AppDao.java <br>
 * Package Name : com.lee.example.sh <br>
 * Create Time : 2016-09-10 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.sh;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lee.example.h.entity.Group;
import com.lee.example.h.entity.User;

/**
 * ClassName : AppDao <br>
 * Description application dao <br>
 * Create Time : 2016-09-10 <br>
 * Create by : jimmyblylee@126.com
 */
@Repository
public class AppDao {

    @Resource(name = "sessionFactory")
    private SessionFactory factory;
    
    public Session getSession() {
        return factory.getCurrentSession();
    }
    
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return getSession().createQuery("from User").getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Group> getAllGroups() {
        return getSession().createQuery("from Group").getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<User> getAllUsersNoLazy() {
        StringBuilder hql = new StringBuilder();
        hql.append(" select distinct u from User as u");
        hql.append(" left join fetch u.sex");
        hql.append(" left join fetch u.role");
        hql.append(" left join fetch u.groups");
        hql.append(" left join fetch u.type");
        return getSession().createQuery(hql.toString()).getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Group> getAllGroupsNoLazy() {
        StringBuilder hql = new StringBuilder();
        hql.append("select distinct g from Group as g");
        hql.append(" left join fetch g.users");
        return getSession().createQuery(hql.toString()).getResultList();
    }
}
