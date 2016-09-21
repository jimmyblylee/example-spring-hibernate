/**
 * Project Name : example-hibernate-entity-over-interface <br>
 * File Name : GroupName.java <br>
 * Package Name : com.lee.example.h.entity <br>
 * Create Time : 2016-09-21 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.h.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ClassName : GroupName <br>
 * Description : group nameable implementation entity <br>
 * Create Time : 2016-09-21 <br>
 * Create by : jimmyblylee@126.com
 */
@Entity
@Table(name = "APP_GROUP")
public class GroupName implements Nameable {

    private static final long serialVersionUID = -71031071890222910L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROUP_ID")
    private Integer id;
    @Column(name = "GROUP_NAME")
    private String name;

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
}
