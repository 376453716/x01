package com.xh.Entity;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by xionghao on 16/11/2015.
 */
public class XDateTest {

    private final static Logger log = Logger.getLogger(XDateTest.class);
    private final static String DATE_TIME_FORMATTER = "dd/mm/yyyy";

    @Test

    public void test() {
    String birthDay = "01/01/1989";
        int age = 0;
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/mm/yyyy");
            Date dob = sdf1.parse(birthDay);
            Calendar today = Calendar.getInstance();
            Calendar birthCalendar = Calendar.getInstance();
            birthCalendar.setTime(dob);
            age = today.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);
            if (today.get(Calendar.MONTH) < birthCalendar.get(Calendar.MONTH)) {
                age--;
            } else if (today.get(Calendar.MONTH) == birthCalendar.get(Calendar.MONTH) &&
                    today.get(Calendar.DAY_OF_MONTH) < birthCalendar.get(Calendar.DAY_OF_MONTH)) {
                age--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("age="+age);
    }
}
