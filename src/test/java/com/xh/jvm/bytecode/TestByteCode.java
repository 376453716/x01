package com.xh.jvm.bytecode;

/**
 * @author Xiong Hao
 */
public class TestByteCode {

    void spin() {
        int i;
        for (i = 0; i < 100; i++) {
            ; // Loop body is empty
        }
    }
}
