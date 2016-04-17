package com.xh.framework;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.datetime.DateFormatter;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * Created by xh on 03/04/16.
 */
public class CustomDateConvert implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        DateFormatter dateFormatter = new DateFormatter();
        try {
            return dateFormatter.parse(source, Locale.CHINA);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
