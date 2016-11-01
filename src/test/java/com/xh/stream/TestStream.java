package com.xh.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Xiong Hao
 */
public class TestStream {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("d");
        list.add("e");
        Optional<String> opt = list.stream().filter(str -> "a".equals(str)).findFirst();
        System.out.println(opt.get());
    }
}
