/**
 * Project Name : example-hibernate-entity-over-interface <br>
 * File Name : DictImpl.java <br>
 * Package Name : com.lee.example.h.entity <br>
 * Create Time : 2016-09-21 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.h.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * ClassName : DictImpl <br>
 * Description : entity of dict <br>
 * Create Time : 2016-09-21 <br>
 * Create by : jimmyblylee@126.com
 */
@Entity
@Table(name = "APP_DICT")
@IdClass(value = DictPK.class)
public class DictImpl implements Serializable, Dict {

    private static final long serialVersionUID = 5235397014073754225L;

    @Id
    @Column(name = "DICT_NATURE", nullable = false, length = 25)
    private String nature;

    @Id
    @Column(name = "DICT_CODE", nullable = false, length = 25)
    private String code;

    @Column(name = "DICT_VALUE", nullable = false, length = 50)
    private String value;

    /* (non-Javadoc)
     * @see com.lee.example.h.entity.Dict#getNature()
     */
    @Override
    public String getNature() {
        return nature;
    }

    /* (non-Javadoc)
     * @see com.lee.example.h.entity.Dict#setNature(java.lang.String)
     */
    @Override
    public void setNature(String nature) {
        this.nature = nature;
    }

    /* (non-Javadoc)
     * @see com.lee.example.h.entity.Dict#getCode()
     */
    @Override
    public String getCode() {
        return code;
    }

    /* (non-Javadoc)
     * @see com.lee.example.h.entity.Dict#setCode(java.lang.String)
     */
    @Override
    public void setCode(String code) {
        this.code = code;
    }

    /* (non-Javadoc)
     * @see com.lee.example.h.entity.Dict#getValue()
     */
    @Override
    public String getValue() {
        return value;
    }

    /* (non-Javadoc)
     * @see com.lee.example.h.entity.Dict#setValue(java.lang.String)
     */
    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
