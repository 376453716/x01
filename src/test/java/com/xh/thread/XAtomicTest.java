package com.xh.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xh on 11/03/16.
 */
public class XAtomicTest {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger();
        final int[] x = {100};
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true)
                        x[0]++;
                }
            }).start();
        }
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true)
                        x[0]--;
                }
            }).start();
        }
        System.out.println(x[0]);

    }
}
