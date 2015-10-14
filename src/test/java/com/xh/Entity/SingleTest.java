package com.xh.Entity;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by xh on 14/10/15.
 */
public class SingleTest {

    Logger log = Logger.getLogger(this.getClass());

    @Test
    public void testCOnnection(){
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xh","xh","xh");
            log.info(connection.getMetaData().getDatabaseProductVersion());
            log.info(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
