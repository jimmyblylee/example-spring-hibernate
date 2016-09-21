/**
 * Project Name : example-hibernate-entity-over-interface <br>
 * File Name : Nameable.java <br>
 * Package Name : com.lee.example.h.entity <br>
 * Create Time : 2016-09-21 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.h.entity;

import java.io.Serializable;

/**
 * ClassName : Nameable <br>
 * Description : entity that nameable <br>
 * Create Time : 2016-09-21 <br>
 * Create by : jimmyblylee@126.com
 */
public interface Nameable extends Serializable {

    public Integer getId();

    public void setId(Integer id);

    public String getName();

    public void setName(String name);
}
