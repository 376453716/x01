package com.xh.util;

/**
 * Created by xionghao on 30/10/2015.
 */
public class XCommonUtil {

    public static String getClassFilePath(String className) {
        return XCommonUtil.class.getResource(className).getPath();
    }
}
