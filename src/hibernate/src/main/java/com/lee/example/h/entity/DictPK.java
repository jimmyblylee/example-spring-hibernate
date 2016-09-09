/**
 * Project Name : hibernate <br>
 * File Name : DictPK.java <br>
 * Package Name : com.lee.example.h.entity <br>
 * Create Time : Sep 9, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.h.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * ClassName : DictPK <br>
 * Description : pk of entity dict <br>
 * Create Time : Sep 9, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 *
 */
@Embeddable
public class DictPK implements Serializable {

    private static final long serialVersionUID = 1579588395579622582L;

    private String nature;
    private String code;

    public DictPK(String nature, String code) {
        super();
        this.nature = nature;
        this.code = code;
    }

    public DictPK() {
    }

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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nature == null) ? 0 : nature.hashCode());
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DictPK other = (DictPK) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        if (nature == null) {
            if (other.nature != null)
                return false;
        } else if (!nature.equals(other.nature))
            return false;
        return true;
    }
}
