/**
 * Project Name : example-spring-hibernate-jpa-atomikos <br>
 * File Name : User2.java <br>
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

/**
 * ClassName : User2 <br>
 * Description : entity for APP_USER with relation entity group <br>
 * <b>IMPOTANT!</b> please see the interpretation of why create this file in {@link GroupUser} <br>
 * Create Time : 2016-09-12 <br>
 * Create by : jimmyblylee@126.com
 */
@Entity
@Table(name = "APP_USER")
public class User2 implements Serializable {

    private static final long serialVersionUID = -816481557988770L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Integer id;

    @Column(name = "USER_NAME")
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private List<GroupUser> gus;

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

    /**
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role the role to set
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
     * @param sex the sex to set
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
     * @param type the type to set
     */
    public void setType(Dict type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return getName();
    }
}
