/**
 * Project Name : example-spring-hibernate-jpa-atomikos <br>
 * File Name : OutputData.java <br>
 * Package Name : com.lee.example.shja <br>
 * Create Time : Sep 9, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.example.shja;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName : OutputData <br>
 * Description : output the data in db <br>
 * Create Time : Sep 9, 2016 <br>
 * Create by : jimmyblylee@126.com <br>
 *
 */
public class OutputData {
    
    public void print() {
        @SuppressWarnings("resource")
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("classpath*:spring-context.xml");
        AppController controller = appCtx.getBean(AppController.class);
        controller.print();
    }

    /**
     * Description : output the data in db <br>
     * Create Time: Sep 9, 2016 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param args no args accepted
     */
    public static void main(String[] args) {
        new OutputData().print();
    }

}
