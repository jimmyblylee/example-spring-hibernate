/**
 * Project Name : example-hibernate-entity-over-interface <br>
 * File Name : GroupImpl.java <br>
 * Package Name : com.lee.example.h.entity <br>
 * Create Time : 2016-09-21 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.h.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * ClassName : GroupImpl <br>
 * Description : entity of Group <br>
 * Create Time : 2016-09-21 <br>
 * Create by : jimmyblylee@126.com
 */
@Entity
@Table(name = "APP_GROUP")
public class GroupImpl implements Serializable, Group {

    private static final long serialVersionUID = 8029732025163157900L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROUP_ID")
    private Integer id;

    @Column(name = "GROUP_NAME")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "groups", targetEntity = UserImpl.class)
    private List<User> users;

    /*
     * (non-Javadoc)
     * @see com.lee.example.h.entity.Group#toString()
     */
    @Override
    public String toString() {
        return getName();
    }

    /*
     * (non-Javadoc)
     * @see com.lee.example.h.entity.Group#getId()
     */
    @Override
    public Integer getId() {
        return id;
    }

    /*
     * (non-Javadoc)
     * @see com.lee.example.h.entity.Group#setId(java.lang.Integer)
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    /*
     * (non-Javadoc)
     * @see com.lee.example.h.entity.Group#getName()
     */
    @Override
    public String getName() {
        return name;
    }

    /*
     * (non-Javadoc)
     * @see com.lee.example.h.entity.Group#setName(java.lang.String)
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * @see com.lee.example.h.entity.Group#getUsers()
     */
    @Override
    public List<User> getUsers() {
        return users;
    }

    /*
     * (non-Javadoc)
     * @see com.lee.example.h.entity.Group#setUsers(java.util.List)
     */
    @Override
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
