package com.lee.example.h.entity;

import java.util.List;

public interface User {

    String toString();

    /**
     * @return the id
     */
    Integer getId();

    /**
     * @param id
     *            the id to set
     */
    void setId(Integer id);

    /**
     * @return the name
     */
    String getName();

    /**
     * @param name
     *            the name to set
     */
    void setName(String name);

    /**
     * @return the groups
     */
    List<Group> getGroups();

    /**
     * @param groups
     *            the groups to set
     */
    void setGroups(List<Group> groups);

    /**
     * @return the role
     */
    Role getRole();

    /**
     * @param role
     *            the role to set
     */
    void setRole(Role role);

    /**
     * @return the sex
     */
    Dict getSex();

    /**
     * @param sex
     *            the sex to set
     */
    void setSex(Dict sex);

    /**
     * @return the type
     */
    Dict getType();

    /**
     * @param type
     *            the type to set
     */
    void setType(Dict type);

}