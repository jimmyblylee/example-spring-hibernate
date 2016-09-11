/**
 * Project Name : example-spring-hibernate-jpa <br>
 * File Name : AppDao.java <br>
 * Package Name : com.lee.example.shj <br>
 * Create Time : 2016-09-10 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.shj;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lee.example.h.entity.Group;
import com.lee.example.h.entity.Role;
import com.lee.example.h.entity.User;

/**
 * ClassName : AppDao <br>
 * Description application dao <br>
 * Create Time : 2016-09-10 <br>
 * Create by : jimmyblylee@126.com
 */
@Repository
public class AppDao {

    @PersistenceContext(unitName = "data_mgmt")
    private EntityManager em;
    
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return em.createQuery("from User").getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Group> getAllGroups() {
        return em.createQuery("from Group").getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<User> getAllUsersNoLazy() {
        StringBuilder hql = new StringBuilder();
        hql.append(" select distinct u from User as u");
        hql.append(" left join fetch u.sex");
        hql.append(" left join fetch u.role");
        hql.append(" left join fetch u.groups");
        hql.append(" left join fetch u.type");
        return em.createQuery(hql.toString()).getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Group> getAllGroupsNoLazy() {
        StringBuilder hql = new StringBuilder();
        hql.append("select distinct g from Group as g");
        hql.append(" left join fetch g.users");
        return em.createQuery(hql.toString()).getResultList();
    }

    public void saveTestData(Object entity) {
        em.persist(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Role> getTestData() {
        return em.createQuery("from Role as r where r.name = :name").setParameter("name", "testData").getResultList();
    }

    public void clearTestData() {
        em.createQuery("delete from Role as r where r.name = :name").setParameter("name", "testData").executeUpdate();
    }
}
