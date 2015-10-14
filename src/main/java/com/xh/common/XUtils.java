package com.xh.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xh on 15/10/15.
 */
public class XUtils {

    public static final String DEFAULT_DATE_PATTRN = "dd/MM/yyyy";

    public static String fomateDate(Date date, String pattrn) {
        if (StringUtils.isNotBlank(pattrn)) {
            pattrn = DEFAULT_DATE_PATTRN;
        }
        SimpleDateFormat format = new SimpleDateFormat(pattrn);
        return format.format(date);
    }

    public static String fomateDate(Date date) {
        return fomateDate(date, DEFAULT_DATE_PATTRN);
    }
}
