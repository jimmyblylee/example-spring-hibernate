/**
 * Project Name : hibernate <br>
 * File Name : OutputData.java <br>
 * Package Name : com.lee.example.h <br>
 * Create Time : Sep 9, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.h;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lee.example.h.entity.Group;
import com.lee.example.h.entity.User;

/**
 * ClassName : OutputData <br>
 * Description : output the data in db <br>
 * Create Time : Sep 9, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 *
 */
public class OutputData {
    private Logger log = LoggerFactory.getLogger(getClass());
    
    public void print() {
        Service service = new Service();
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
        service.close();
    }

    /**
     * Description : output the data in db <br>
     * Create Time: Sep 9, 2016 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param args
     */
    public static void main(String[] args) {
        new OutputData().print();
    }

}
