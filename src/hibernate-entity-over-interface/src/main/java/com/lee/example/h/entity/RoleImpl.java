/**
 * Project Name : example-hibernate-entity-over-interface <br>
 * File Name : RoleImpl.java <br>
 * Package Name : com.lee.example.h.entity <br>
 * Create Time : 2016-09-21 <br>
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
 * ClassName : RoleImpl <br>
 * Description : entity of role <br>
 * Create Time : 2016-09-21 <br>
 * Create by : jimmyblylee@126.com
 */
@Entity
@Table(name = "APP_ROLE")
public class RoleImpl implements Serializable, Role {

    private static final long serialVersionUID = 5189119027018828659L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Integer id;
    
    @Column(name = "ROLE_NAME")
    private String name;

    /* (non-Javadoc)
     * @see com.lee.example.h.entity.Role#getId()
     */
    @Override
    public Integer getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see com.lee.example.h.entity.Role#setId(java.lang.Integer)
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see com.lee.example.h.entity.Role#getName()
     */
    @Override
    public String getName() {
        return name;
    }

    /* (non-Javadoc)
     * @see com.lee.example.h.entity.Role#setName(java.lang.String)
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }
}
