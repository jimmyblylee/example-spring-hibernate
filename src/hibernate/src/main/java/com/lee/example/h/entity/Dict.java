/**
 * Project Name : hibernate <br>
 * File Name : Dict.java <br>
 * Package Name : com.lee.example.h.entity <br>
 * Create Time : Sep 9, 2016 <br>
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
 * ClassName : Dict <br>
 * Description : entity of dict <br>
 * Create Time : Sep 9, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 *
 */
@Entity
@Table(name = "APP_DICT")
@IdClass(value = DictPK.class)
public class Dict implements Serializable {

    private static final long serialVersionUID = 5235397014073754225L;

    @Id
    @Column(name = "DICT_NATURE", nullable = false, length = 25)
    private String nature;

    @Id
    @Column(name = "DICT_CODE", nullable = false, length = 25)
    private String code;

    @Column(name = "DICT_VALUE", nullable = false, length = 50)
    private String value;

    /**
     * @return the nature
     */
    public String getNature() {
        return nature;
    }

    /**
     * @param nature
     *            the nature to set
     */
    public void setNature(String nature) {
        this.nature = nature;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
}
