/**
 * Project Name : example-spring-hibernate <br>
 * File Name : AppService.java <br>
 * Package Name : com.lee.example.sh <br>
 * Create Time : Sep 10, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.sh;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lee.example.h.entity.Group;
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

}
