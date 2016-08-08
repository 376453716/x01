package com.xh.thread.unsafe;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Xiong Hao
 */
public class TestUnsafe {

    /**
     * create unsafe instans
     */
    @Test
    public void test1() throws Exception {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe unsafe = (Unsafe) field.get(null);
            System.out.println(unsafe);
            System.out.println(unsafe.addressSize());
            System.out.println(unsafe.pageSize());
            System.out.println(unsafe.getInt(1l));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
