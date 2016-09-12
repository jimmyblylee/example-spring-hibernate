/**
 * Project Name : example-spring-hibernate-jpa-atomikos <br>
 * File Name : AppService.java <br>
 * Package Name : com.lee.example.shja <br>
 * Create Time : Sep 10, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.shja;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

import java.util.List;

import javax.annotation.Resource;

import org.perf4j.aop.Profiled;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lee.example.h.entity.Group;
import com.lee.example.h.entity.Role;
import com.lee.example.h.entity.User;

/**
 * ClassName : AppService <br>
 * Description : application service <br>
 * Create Time : Sep 10, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 *
 */
@Service
@Scope(value = SCOPE_PROTOTYPE)
public class AppService {
    
    public final static String CNS_MANUAL_FAIL_MSG = "Test failure, and the tx should rollback here!";

    @Resource
    private AppDao dao;

    /**
     * Description : get all users with all properties <br>
     * Create Time: 2016-09-10 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @return all users in the database
     */
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return dao.getAllUsersNoLazy();
    }

    /**
     * Description : get all groups with all properties <br>
     * Create Time: 2016-09-10 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @return all groups in the database
     */
    @Transactional(readOnly = true)
    public List<Group> getAllGroups() {
        return dao.getAllGroupsNoLazy();
    }

    /**
     * Description : get all the users for lazy properties test <br>
     * Create Time: 2016-09-10 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @return all users with lazy properties which are not initialized
     */
    @Transactional(readOnly = true)
    public List<User> getAllUsers4LazyTest() {
        return dao.getAllUsers();
    }

    /**
     * Description : craete a Role for test with name "testData" <br>
     * Create Time: 2016-09-11 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     */
    @Transactional(readOnly = false)
    public void createOneTestDataSuccess() {
        Role role = new Role();
        role.setName("testData");
        dao.saveTestData(role);
    }
    
    /**
     * Description : craete a Role for test with name "testData", but failed with exception <br>
     * Create Time: 2016-09-11 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     */
    @Transactional(readOnly = false)
    public void createOneTestDataFail() {
        Role role = new Role();
        role.setName("testData");
        dao.saveTestData(role);
        throw new RuntimeException(CNS_MANUAL_FAIL_MSG);
    }

    /**
     * Description : get the count of Role which name is "testData" <br>
     * Create Time: 2016-09-11 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @return the count of Role with name testData
     */
    @Transactional(readOnly = true)
    public Integer getTestDataCount() {
        return dao.getTestData().size();
    }

    /**
     * Description : clear all the Role with name "testData" <br>
     * Create Time: 2016-09-11 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     */
    @Transactional(readOnly = false)
    public void clearTestData() {
        dao.clearTestData();
    }

    /**
     * Description : craete a Role for test with name "testData" <br>
     * Create Time: 2016-09-11 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     */
    @Transactional(readOnly = false)
    public void createOneTestDataSuccessWithEmB() {
        Role role = new Role();
        role.setName("testDataB");
        dao.saveTestDataWithEmB(role);
    }
    
    /**
     * Description : craete a Role for test with name "testData", but failed with exception with EntityManager B <br>
     * Create Time: 2016-09-11 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     */
    @Profiled
    @Transactional(readOnly = false)
    public void createOneTestDataFailWithEmB() {
        Role role = new Role();
        role.setName("testDataB");
        dao.saveTestDataWithEmB(role);
        throw new RuntimeException(CNS_MANUAL_FAIL_MSG);
    }

    /**
     * Description : get the count of Role which name is "testData" with EntityManager B <br>
     * Create Time: 2016-09-11 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @return the count of Role with name testDataB
     */
    @Profiled
    @Transactional(readOnly = true)
    public Integer getTestDataCountWithEmB() {
        return dao.getTestDataWithEmB().size();
    }

    /**
     * Description : clear all the Role with name "testData" with EntityManager B<br>
     * Create Time: 2016-09-11 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     */
    @Profiled
    @Transactional(readOnly = false)
    public void clearTestDataWithEmB() {
        dao.clearTestDataWithEmB();
    }
    
    @Transactional(readOnly = false)
    public void createTwoDataByEmAAndEmBSuccess() {
        createOneTestDataSuccess();
        createOneTestDataSuccessWithEmB();
    }
    
    @Transactional(readOnly = false)
    public void createTwoDataByEmAAndEmBFailure() {
        createOneTestDataSuccess();
        createOneTestDataSuccessWithEmB();
        throw new RuntimeException(CNS_MANUAL_FAIL_MSG);
    }

}
