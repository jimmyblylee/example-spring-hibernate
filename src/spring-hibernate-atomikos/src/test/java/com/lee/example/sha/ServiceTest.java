/**
 * Project Name : example-spring-hibernate-atomikos <br>
 * File Name : ServiceTest.java <br>
 * Package Name : com.lee.example.sha <br>
 * Create Time : Sep 9, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.sha;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lee.example.h.entity.Group2;
import com.lee.example.h.entity.User2;

/**
 * ClassName : ServiceTest <br>
 * Description : Unit test for Service <br>
 * Create Time : Sep 9, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-context.xml" })
public class ServiceTest {

    @Resource
    private AppService service;

    @Test
    public void testGetAllGroup() {
        List<Group2> groups = service.getAllGroups();
        assertNotNull(groups);
        assertThat(groups.size(), is(2));
        for (Group2 group : groups) {
            assertThat(group.getGus(), notNullValue());
            assertThat(group.getGus().size(), greaterThan(0));
        }
    }

    @Test
    public void testGetAllUser() {
        List<User2> users = service.getAllUsers();
        assertNotNull(users);
        assertThat(users.size(), is(6));
        assertThat(users.toString(), containsString("Jimmy"));
    }

    @Test
    public void testGetUserLazyProperties() {
        List<User2> users = service.getAllUsers4LazyTest();
        assertNotNull(users);
        assertThat(users.size(), greaterThan(0));
        User2 user = users.get(0);
        assertThat(user, notNullValue());
        assertThat(user.getName(), notNullValue());

        try {
            user.getType().getValue();
        } catch (Exception e) {
            assertThat(e, instanceOf(LazyInitializationException.class));
        }
    }

    @Test
    public void testUpdateDatabaseSuccess() {
        service.clearTestData();
        assertThat(service.getTestDataCount(), is(0));
        service.createOneTestDataSuccess();
        assertThat(service.getTestDataCount(), is(1));
        service.createOneTestDataSuccess();
        assertThat(service.getTestDataCount(), is(2));
        service.clearTestData();
        assertThat(service.getTestDataCount(), is(0));
    }

    @Test
    public void testUpdateDatabaseFailure() {
        service.clearTestData();
        assertThat(service.getTestDataCount(), is(0));
        try {
            service.createOneTestDataFail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is(AppService.CNS_MANUAL_FAIL_MSG));
        }
        assertThat(service.getTestDataCount(), is(0));
    }

    @Test
    public void testUpdateDatabaseSuccessWithEmB() {
        service.clearTestDataWithEmB();
        assertThat(service.getTestDataCountWithEmB(), is(0));
        service.createOneTestDataSuccessWithEmB();
        assertThat(service.getTestDataCountWithEmB(), is(1));
        service.createOneTestDataSuccessWithEmB();
        assertThat(service.getTestDataCountWithEmB(), is(2));
        service.clearTestDataWithEmB();
        assertThat(service.getTestDataCountWithEmB(), is(0));
    }

    @Test
    public void testUpdateDatabaseFailureWithEmB() {
        service.clearTestDataWithEmB();
        assertThat(service.getTestDataCountWithEmB(), is(0));
        try {
            service.createOneTestDataFailWithEmB();
        } catch (Exception e) {
            assertThat(e.getMessage(), is(AppService.CNS_MANUAL_FAIL_MSG));
        }
        assertThat(service.getTestDataCountWithEmB(), is(0));
    }
    
    @Test
    public void testDistributedTransactionSuccess() {
        service.clearTestData();
        assertThat(service.getTestDataCount(), is(0));
        service.clearTestDataWithEmB();
        assertThat(service.getTestDataCountWithEmB(), is(0));
        
        service.createTwoDataByEmAAndEmBSuccess();
        assertThat(service.getTestDataCount(), is(1));
        assertThat(service.getTestDataCountWithEmB(), is(1));
        
        service.createTwoDataByEmAAndEmBSuccess();
        assertThat(service.getTestDataCount(), is(2));
        assertThat(service.getTestDataCountWithEmB(), is(2));
        
        service.clearTestData();
        assertThat(service.getTestDataCount(), is(0));
        service.clearTestDataWithEmB();
        assertThat(service.getTestDataCountWithEmB(), is(0));
    }
    
    @Test
    public void testDistributedTransactionFailure() {
        service.clearTestData();
        assertThat(service.getTestDataCount(), is(0));
        service.clearTestDataWithEmB();
        assertThat(service.getTestDataCountWithEmB(), is(0));

        try {
            service.createTwoDataByEmAAndEmBFailure();
        } catch (Exception e) {
            assertThat(e.getMessage(), is(AppService.CNS_MANUAL_FAIL_MSG));
        }
        assertThat(service.getTestDataCount(), is(0));
        assertThat(service.getTestDataCountWithEmB(), is(0));
        
    }
}
