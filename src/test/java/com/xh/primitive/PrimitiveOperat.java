package com.xh.primitive;

import org.junit.Test;

/**
 * @author Xiong Hao
 */
public class PrimitiveOperat {

    @Test
    public void test() {
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;
        System.out.println(String.format("%x", a));
        System.out.println(String.format("%d", a));
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(8 >> 1));
        System.out.println(Integer.toBinaryString(8 >>> 1));
        System.out.println(Integer.toBinaryString(8 << 1));
        System.out.println(Integer.toBinaryString(a >> 1));
        System.out.println(Integer.toBinaryString(a >>> 1));
        System.out.println(Integer.toBinaryString(a << 1));
    }
}
