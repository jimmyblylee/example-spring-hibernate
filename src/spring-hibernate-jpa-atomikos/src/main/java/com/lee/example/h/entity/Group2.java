/**
 * Project Name : example-spring-hibernate-jpa-atomikos <br>
 * File Name : Group2.java <br>
 * Package Name : com.lee.example.h.entity <br>
 * Create Time : 2016-09-12 <br>
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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ClassName : Group2 <br>
 * Description : entity for APP_GROUP, and make relation to "APP_GROUP_USER" <br>
 * <b>IMPOTANT!</b> please see the interpretation of why create this file in {@link GroupUser} <br>
 * Create Time : 2016-09-12 <br>
 * Create by : jimmyblylee@126.com
 */
@Entity
@Table(name = "APP_GROUP")
public class Group2 implements Serializable {

    private static final long serialVersionUID = -3240579879591054055L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROUP_ID")
    private Integer id;

    @Column(name = "GROUP_NAME")
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID")
    private List<GroupUser> gus;

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the gus
     */
    public List<GroupUser> getGus() {
        return gus;
    }

    /**
     * @param gus the gus to set
     */
    public void setGus(List<GroupUser> gus) {
        this.gus = gus;
    }

    @Override
    public String toString() {
        return getName();
    }
}
