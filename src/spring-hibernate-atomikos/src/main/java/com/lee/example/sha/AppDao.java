/**
 * Project Name : example-spring-hibernate-atomikos <br>
 * File Name : AppDao.java <br>
 * Package Name : com.lee.example.sha <br>
 * Create Time : 2016-09-10 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.sha;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

    @Resource(name = "sessionFactory_A")
    private SessionFactory factoryA;
    @Resource(name = "sessionFactory_B")
    private SessionFactory factoryB;
    
    private Session getSession() {
        return factoryA.getCurrentSession();
    }
    
    private Session getSessionB() {
        return factoryB.getCurrentSession();
    }
    
    @SuppressWarnings("unchecked")
    public List<User2> getAllUsers() {
        return getSession().createQuery("from User2").getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Group2> getAllGroups() {
        return getSession().createQuery("from Group2").getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<User2> getAllUsersNoLazy() {
        StringBuilder hql = new StringBuilder();
        hql.append(" select distinct u from User2 as u");
        hql.append(" left join fetch u.sex");
        hql.append(" left join fetch u.role");
        hql.append(" left join fetch u.gus");
        hql.append(" left join fetch u.type");
        return getSession().createQuery(hql.toString()).getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Group2> getAllGroupsNoLazy() {
        StringBuilder hql = new StringBuilder();
        hql.append("select distinct g from Group2 as g");
        hql.append(" left join fetch g.gus");
        return getSession().createQuery(hql.toString()).getResultList();
    }

    public void saveTestData(Object entity) {
        getSession().persist(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Role> getTestData() {
        return getSession().createQuery("from Role as r where r.name = :name").setParameter("name", "testData").getResultList();
    }

    public void clearTestData() {
        getSession().createQuery("delete from Role as r where r.name = :name").setParameter("name", "testData").executeUpdate();
    }
    
    public void saveTestDataWithEmB(Object entity) {
        getSessionB().persist(entity);
    }
    
    @SuppressWarnings("unchecked")
    public List<Role> getTestDataWithEmB() {
        return getSessionB().createQuery("from Role as r where r.name = :name").setParameter("name", "testDataB").getResultList();
    }

    public void clearTestDataWithEmB() {
        getSessionB().createQuery("delete from Role as r where r.name = :name").setParameter("name", "testDataB").executeUpdate();
    }
}
