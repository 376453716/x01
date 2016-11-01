package com.xh.guava;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Xiong Hao
 */
public class TestNull {

    private static final Random random = new Random(50);

    @Test
    public void test() {
        List<String> list = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i, String.valueOf(random.nextInt()));
        }
        System.out.println(list);
    }
}
