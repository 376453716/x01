package com.xh.thread;

import java.util.concurrent.*;

/**
 * Created by xh on 11/03/16.
 */
public class RecallTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Future future = service.submit(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(10);
                return "call.........";
            }

            public void run() {
                System.out.println("test began...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("test end...");
            }
        });
//        System.out.println(future.isCancelled());
//        System.out.println(future.isDone());
        //Thread.sleep(5);
        System.out.println("cancle =====" + future.cancel(false));
        System.out.println("done====" + future.isDone());
        System.out.println(future.isCancelled());
        System.out.println(future.isDone());
        Thread.sleep(5);
        try {
            System.out.println(future.get() + "get result== ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
