package com.lee.example.h.entity;

import java.util.List;

public interface Group {

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
     * @return the users
     */
    List<User> getUsers();

    /**
     * @param users
     *            the users to set
     */
    void setUsers(List<User> users);

}