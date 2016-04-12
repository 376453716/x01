package com.xh.Entity;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xh on 14/10/15.
 */
public class SingleTest {

    Logger log = Logger.getLogger(this.getClass());

    @Test
    public void testCOnnection() {
        Connection connection = null;

        try {
            /*Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xh","xh","xh");
            log.info(connection.getMetaData().getDatabaseProductVersion());
            log.info(connection);*/
            log.info(checkDateAfter("01/01/2015", "01/01/2012"));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    private boolean checkDateAfter(String sDateFrom, String dateTag) throws ParseException {
        if (sDateFrom == null || sDateFrom.equals(""))
            return false;
        if (dateTag == null || dateTag.equals(""))
            return false;
        SimpleDateFormat oFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date dtFrom = oFormat.parse(sDateFrom);
        java.util.Date dtTo = oFormat.parse(dateTag);
        return dtTo.after(dtFrom);
    }
}
