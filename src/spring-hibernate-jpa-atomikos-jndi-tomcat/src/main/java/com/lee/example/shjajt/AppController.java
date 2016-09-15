/**
 * Project Name : example-spring-hibernate-jpa-atomikos-jndi <br>
 * File Name : AppController.java <br>
 * Package Name : com.lee.example.shjajt <br>
 * Create Time : 2016-09-15 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.shjajt;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lee.example.h.entity.Group;
import com.lee.example.h.entity.User;
import com.lee.example.shjajt.AppService;

/**
 * ClassName : AppController <br>
 * Description : application controller <br>
 * Create Time : 2016-09-15 <br>
 * Create by : jimmyblylee@126.com
 */
@Controller
@Scope(value = SCOPE_PROTOTYPE)
@RequestMapping("/test")
public class AppController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private AppService service;

    @RequestMapping(method = RequestMethod.GET)
    public void print(HttpServletResponse res) {
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
        res.setContentType("text/html;charset=UTF-8");
        try {
            res.getWriter().write("Request Success! Please see the log of the background!");
        } catch (IOException e) {
            log.error("error occur while write response!", e);
        }
    }

}
