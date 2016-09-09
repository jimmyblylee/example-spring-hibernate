/**
 * Project Name : example-hibernate-entity <br>
 * File Name : Role.java <br>
 * Package Name : com.lee.example.h.entity <br>
 * Create Time : Sep 9, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.h.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ClassName : Role <br>
 * Description : entity of role <br>
 * Create Time : Sep 9, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 *
 */
@Entity
@Table(name = "APP_ROLE")
public class Role implements Serializable {

    private static final long serialVersionUID = 5189119027018828659L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Integer id;
    
    @Column(name = "ROLE_NAME")
    private String name;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
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
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
