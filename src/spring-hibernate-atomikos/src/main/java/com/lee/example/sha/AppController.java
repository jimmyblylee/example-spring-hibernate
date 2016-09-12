/**
 * Project Name : example-spring-hibernate-atomikos <br>
 * File Name : AppController.java <br>
 * Package Name : com.lee.example.sha <br>
 * Create Time : Sep 10, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.sha;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lee.example.h.entity.Group;
import com.lee.example.h.entity.User;

/**
 * ClassName : AppController <br>
 * Description : application controller <br>
 * Create Time : Sep 10, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 *
 */
@Controller
@Scope(value = SCOPE_PROTOTYPE)
public class AppController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private AppService service;

    public void print() {
        List<User> users = service.getAllUsers();
        List<Group> groups = service.getAllGroups();
        log.info("users {} are found!", users);
        for (User user : users) {
            log.info("-------------");
            log.info("User {} is found,", user.getName());
            log.info("{}'s sex is {}, role is {}, type is {}", user.getName(), user.getSex().getValue(), user.getRole().getName(), user.getType().getValue());
            log.info("And user is in group {}", user.getGroups());
        }
        log.info("#####################");
        log.info("groups {} are found!", groups);
        for (Group group : groups) {
            log.info("group {} has users {}", group, group.getUsers());
        }
    }
}
