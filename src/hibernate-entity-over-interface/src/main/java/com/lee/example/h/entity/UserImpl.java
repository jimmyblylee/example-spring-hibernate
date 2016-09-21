/**
 * Project Name : example-hibernate-entity-over-interface <br>
 * File Name : UserImpl.java <br>
 * Package Name : com.lee.example.h.entity <br>
 * Create Time : 2016-09-21 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.h.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

/**
 * ClassName : UserImpl <br>
 * Description : entity of user <br>
 * Create Time : 2016-09-21 <br>
 * Create by : jimmyblylee@126.com
 */
@Entity
@Table(name = "APP_USER")
public class UserImpl implements Serializable, User {

    private static final long serialVersionUID = -8162327193657712587L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Integer id;

    @Column(name = "USER_NAME")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = GroupImpl.class)
    @JoinTable(name = "APP_GROUP_USER", joinColumns = { @JoinColumn(name = "USER_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
            @JoinColumn(name = "GROUP_ID", nullable = false, updatable = false) })
    private List<Group> groups;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = RoleImpl.class)
    @JoinColumn(name = "ROLE_ID")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = DictImpl.class)
    @JoinColumnsOrFormulas({ @JoinColumnOrFormula(column = @JoinColumn(name = "SEX", referencedColumnName = "DICT_CODE", nullable = false)),
            @JoinColumnOrFormula(formula = @JoinFormula(referencedColumnName = "DICT_NATURE", value = "'SEX'")) })
    private Dict sex;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = DictImpl.class)
    @JoinColumnsOrFormulas({ @JoinColumnOrFormula(column = @JoinColumn(name = "USER_TYPE", referencedColumnName = "DICT_CODE", nullable = false)),
            @JoinColumnOrFormula(formula = @JoinFormula(referencedColumnName = "DICT_NATURE", value = "'USER_TYPE'")) })
    private Dict type;

    /*
     * (non-Javadoc)
     * @see com.lee.example.h.entity.User#toString()
     */
    @Override
    public String toString() {
        return getName();
    }

    /*
     * (non-Javadoc)
     * @see com.lee.example.h.entity.User#getId()
     */
    @Override
    public Integer getId() {
        return id;
    }

    /*
     * (non-Javadoc)
     * @see com.lee.example.h.entity.User#setId(java.lang.Integer)
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    /*
     * (non-Javadoc)
     * @see com.lee.example.h.entity.User#getName()
     */
    @Override
    public String getName() {
        return name;
    }

    /*
     * (non-Javadoc)
     * @see com.lee.example.h.entity.User#setName(java.lang.String)
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the groups
     */
    @Override
    public List<Group> getGroups() {
        return groups;
    }

    /**
     * @param groups the groups to set
     */
    @Override
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    /*
     * (non-Javadoc)
     * @see com.lee.example.h.entity.User#getRole()
     */
    @Override
    public Role getRole() {
        return role;
    }

    /*
     * (non-Javadoc)
     * @see com.lee.example.h.entity.User#setRole(com.lee.example.h.entity.Role)
     */
    @Override
    public void setRole(Role role) {
        this.role = role;
    }

    /*
     * (non-Javadoc)
     * @see com.lee.example.h.entity.User#getSex()
     */
    @Override
    public Dict getSex() {
        return sex;
    }

    /*
     * (non-Javadoc)
     * @see com.lee.example.h.entity.User#setSex(com.lee.example.h.entity.Dict)
     */
    @Override
    public void setSex(Dict sex) {
        this.sex = sex;
    }

    /*
     * (non-Javadoc)
     * @see com.lee.example.h.entity.User#getType()
     */
    @Override
    public Dict getType() {
        return type;
    }

    /*
     * (non-Javadoc)
     * @see com.lee.example.h.entity.User#setType(com.lee.example.h.entity.Dict)
     */
    @Override
    public void setType(Dict type) {
        this.type = type;
    }
}
