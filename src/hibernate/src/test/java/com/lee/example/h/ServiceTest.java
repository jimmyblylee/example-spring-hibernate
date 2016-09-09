/**
 * Project Name : hibernate <br>
 * File Name : ServiceTest.java <br>
 * Package Name : com.lee.example.h <br>
 * Create Time : Sep 9, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.h;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

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
    
    private static Service service;
    
    @BeforeClass
    public static void init() {
        service = new Service();
    }
    
    @AfterClass
    public static void asfdas() {
        service.close();
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
}
