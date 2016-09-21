/**
 * Project Name : example-hibernate-entity-over-interface <br>
 * File Name : DiffImplTest.java <br>
 * Package Name : com.lee.example.h <br>
 * Create Time : 2016-09-21 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.h;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import com.lee.example.h.entity.GroupName;
import com.lee.example.h.entity.Nameable;
import com.lee.example.h.entity.UserName;

/**
 * ClassName : DiffImplTest <br>
 * Description : test different implementation of entity interface <br>
 * Create Time : 2016-09-21 <br>
 * Create by : jimmyblylee@126.com
 */
public class DiffImplTest {

    @Test
    public void testA() {
        Configuration cfg = new Configuration().configure("hibernate-test-a.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        @SuppressWarnings("unchecked")
        Query<Nameable> query = session.createQuery("from com.lee.example.h.entity.Nameable");
        List<Nameable> list = query.getResultList();
        assertThat(list, notNullValue());
        assertThat(list.size(), is(6));
        System.out.println(list.get(0).getClass());
        assertThat(list.get(0), instanceOf(UserName.class));
        session.clear();
        factory.close();
    }

    @Test
    public void testB() {
        Configuration cfg = new Configuration().configure("hibernate-test-b.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        @SuppressWarnings("unchecked")
        Query<Nameable> query = session.createQuery("from com.lee.example.h.entity.Nameable");
        List<Nameable> list = query.getResultList();
        assertThat(list, notNullValue());
        assertThat(list.size(), is(2));
        assertThat(list.get(0), instanceOf(GroupName.class));
        session.clear();
        factory.close();
    }
}
