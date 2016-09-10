/**
 * Project Name : example-hibernate-jpa <br>
 * File Name : ServiceTest.java <br>
 * Package Name : com.lee.example.hj <br>
 * Create Time : Sep 9, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.sh;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hibernate.LazyInitializationException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lee.example.h.entity.Group;
import com.lee.example.h.entity.User;

/**
 * ClassName : ServiceTest <br>
 * Description : Unit test for Service <br>
 * Create Time : Sep 9, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 *
 */
public class ServiceTest {

    private static AppService service;

    @BeforeClass
    public static void init() {
        @SuppressWarnings("resource")
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("spring-context.xml");
        service = appCtx.getBean(AppService.class);
    }

    @Test
    public void testGetAllGroup() {
        List<Group> groups = service.getAllGroups();
        assertNotNull(groups);
        assertThat(groups.size(), is(2));
        for (Group group : groups) {
            assertThat(group.getUsers(), notNullValue());
            assertThat(group.getUsers().size(), greaterThan(0));
        }
    }

    @Test
    public void testGetAllUser() {
        List<User> users = service.getAllUsers();
        assertNotNull(users);
        assertThat(users.size(), is(6));
        assertThat(users.toString(), containsString("Jimmy"));
    }
    
    @Test
    public void testGetUserLazyProperties() {
        List<User> users = service.getAllUsers4LazyTest();
        assertNotNull(users);
        assertThat(users.size(), greaterThan(0));
        User user = users.get(0);
        assertThat(user, notNullValue());
        assertThat(user.getName(), notNullValue());
        
        try {
            user.getType().getValue();
        } catch (Exception e) {
            assertThat(e, instanceOf(LazyInitializationException.class));
        }
    }
}
