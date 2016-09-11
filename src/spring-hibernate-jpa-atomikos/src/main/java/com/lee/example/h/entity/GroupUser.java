/**
 * Project Name : example-spring-hibernate-jpa-atomikos <br>
 * File Name : GroupUser.java <br>
 * Package Name : com.lee.example.h.entity <br>
 * Create Time : 2016-09-12 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.h.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ClassName : GroupUser <br>
 * Description : relationship between group and user <br>
 * <b>The Reason to create this relation entity BUT not just config the Many2Many relation,</b><br>
 * is that the atomikos will throw exception when getting many2many properties.<br>
 * I don't know why, maybe it's a bug.<br>
 * Create Time : 2016-09-12 <br>
 * Create by : jimmyblylee@126.com
 */
@Entity
@Table(name = "APP_GROUP_USER")
public class GroupUser {

    @Id
    @Column(name = "GROUP_USER_ID")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID")
    private Group2 group;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User2 user;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the group
     */
    public Group2 getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(Group2 group) {
        this.group = group;
    }

    /**
     * @return the user
     */
    public User2 getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User2 user) {
        this.user = user;
    }
}
