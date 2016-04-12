package com.xh.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xh on 11/03/16.
 */
public class ModCountTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String item = it.next();
            System.out.println(item);
            if (item.equals("3")) {
                list.remove(item);
            }
        }
    }
}
