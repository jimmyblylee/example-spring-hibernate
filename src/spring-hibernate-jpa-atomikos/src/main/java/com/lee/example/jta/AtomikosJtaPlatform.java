/**
 * Project Name : example-spring-hibernate-jpa-atomikos <br>
 * File Name : AtomikosJtaPlatform.java <br>
 * Package Name : com.lee.example.jta <br>
 * Create Time : 2016-09-11 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.jta;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import org.hibernate.engine.transaction.jta.platform.internal.AbstractJtaPlatform;

/**
 * ClassName : AtomikosJtaPlatform <br>
 * Description : JTA Platform implementation of Atomikos <br>
 * Create Time : 2016-09-11 <br>
 * Create by : jimmyblylee@126.com
 */
public class AtomikosJtaPlatform extends AbstractJtaPlatform {

    private static final long serialVersionUID = -1863961800814111669L;
    
    private static TransactionManager transactionManager;
    private static UserTransaction transaction;

    @Override
    protected TransactionManager locateTransactionManager() {
        return AtomikosJtaPlatform.transactionManager;
    }

    @Override
    protected UserTransaction locateUserTransaction() {
        return AtomikosJtaPlatform.transaction;
    }

    /**
     * @param transactionManager the transactionManager to set
     */
    public static void setTransactionManager(TransactionManager transactionManager) {
        AtomikosJtaPlatform.transactionManager = transactionManager;
    }

    /**
     * @param transaction the transaction to set
     */
    public static void setTransaction(UserTransaction transaction) {
        AtomikosJtaPlatform.transaction = transaction;
    }
    
    public static void print() {
        System.out.println(AtomikosJtaPlatform.transactionManager);
        System.out.println(AtomikosJtaPlatform.transaction);
    }

}
