/**
 * Project Name : example-hibernate-entity <br>
 * File Name : User.java <br>
 * Package Name : com.lee.example.h.entity <br>
 * Create Time : Sep 9, 2016 <br>
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
 * ClassName : User <br>
 * Description : entity of user <br>
 * Create Time : Sep 9, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 *
 */
@Entity
@Table(name = "APP_USER")
public class User implements Serializable {

    private static final long serialVersionUID = -8162327193657712587L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Integer id;

    @Column(name = "USER_NAME")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "APP_GROUP_USER", joinColumns = { @JoinColumn(name = "USER_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
            @JoinColumn(name = "GROUP_ID", nullable = false, updatable = false) })
    private List<Group> groups;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumnsOrFormulas({ @JoinColumnOrFormula(column = @JoinColumn(name = "SEX", referencedColumnName = "DICT_CODE", nullable = false)),
            @JoinColumnOrFormula(formula = @JoinFormula(referencedColumnName = "DICT_NATURE", value = "'SEX'")) })
    private Dict sex;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumnsOrFormulas({ @JoinColumnOrFormula(column = @JoinColumn(name = "USER_TYPE", referencedColumnName = "DICT_CODE", nullable = false)),
            @JoinColumnOrFormula(formula = @JoinFormula(referencedColumnName = "DICT_NATURE", value = "'USER_TYPE'")) })
    private Dict type;
    
    @Override
    public String toString() {
        return getName();
    }

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

    /**
     * @return the groups
     */
    public List<Group> getGroups() {
        return groups;
    }

    /**
     * @param groups
     *            the groups to set
     */
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    /**
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role
     *            the role to set
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * @return the sex
     */
    public Dict getSex() {
        return sex;
    }

    /**
     * @param sex
     *            the sex to set
     */
    public void setSex(Dict sex) {
        this.sex = sex;
    }

    /**
     * @return the type
     */
    public Dict getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(Dict type) {
        this.type = type;
    }
}
