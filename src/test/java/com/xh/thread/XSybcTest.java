package com.xh.thread;

/**
 * Created by xh on 09/03/16.
 */
public class XSybcTest {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    ServiceTest serviceTest = new ServiceTest();
                    //锁定不同的service实例,可以并行运行
                    serviceTest.test1();
                    serviceTest.test3();
                    //锁定service class,无法并行运行
                    serviceTest.test2();
                }
            });
            thread.start();
        }
    }

}


class ServiceTest {

    //锁定调用对象,this
    public synchronized void test1() {
        System.out.println("service1 start...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("service1 end....");

    }

    //锁定调用对象,this
    public void test3() {
        synchronized (this) {
            System.out.println("service3 start...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("service3 end....");
        }
    }

    //锁定Class
    public static synchronized void test2() {
        System.out.println(Thread.currentThread().getName() + "service2 start...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "service2 end....");

    }
}