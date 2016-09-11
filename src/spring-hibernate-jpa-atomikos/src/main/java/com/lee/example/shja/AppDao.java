/**
 * Project Name : example-spring-hibernate-jpa-atomikos <br>
 * File Name : AppDao.java <br>
 * Package Name : com.lee.example.shja <br>
 * Create Time : 2016-09-10 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.shja;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lee.example.h.entity.Group2;
import com.lee.example.h.entity.Role;
import com.lee.example.h.entity.User2;

/**
 * ClassName : AppDao <br>
 * Description application dao <br>
 * Create Time : 2016-09-10 <br>
 * Create by : jimmyblylee@126.com
 */
@Repository
public class AppDao {

    @PersistenceContext(unitName = "pu_A")
    private EntityManager em;
    @PersistenceContext(unitName = "pu_B")
    private EntityManager emb;
    
    @SuppressWarnings("unchecked")
    public List<User2> getAllUsers() {
        return em.createQuery("from User2").getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Group2> getAllGroups() {
        return em.createQuery("from Group2").getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<User2> getAllUsersNoLazy() {
        StringBuilder hql = new StringBuilder();
        hql.append(" select distinct u from User2 as u");
        hql.append(" left join fetch u.sex");
        hql.append(" left join fetch u.role");
        hql.append(" left join fetch u.gus");
        hql.append(" left join fetch u.type");
        return em.createQuery(hql.toString()).getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Group2> getAllGroupsNoLazy() {
        StringBuilder hql = new StringBuilder();
        hql.append("select distinct g from Group2 as g");
        hql.append(" left join fetch g.gus");
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
    
    public void saveTestDataWithEmB(Object entity) {
        emb.persist(entity);
    }
    
    @SuppressWarnings("unchecked")
    public List<Role> getTestDataWithEmB() {
        return emb.createQuery("from Role as r where r.name = :name").setParameter("name", "testDataB").getResultList();
    }

    public void clearTestDataWithEmB() {
        emb.createQuery("delete from Role as r where r.name = :name").setParameter("name", "testDataB").executeUpdate();
    }
}
