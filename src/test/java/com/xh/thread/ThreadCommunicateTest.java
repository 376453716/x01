package com.xh.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xh on 10/03/16.
 */
public class ThreadCommunicateTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        WaterPool pool = new WaterPool();
        executorService.submit(new WaterIn(pool));
        //executorService.submit(new WaterIn(pool));
        executorService.submit(new WaterOut(pool));
    }
}


class WaterPool {
    private boolean emptyPool = true;

    public synchronized void waterIn() {
        emptyPool = false;
        System.out.println("warter in......" + Thread.currentThread().getName());
        notifyAll();
    }

    public synchronized void waterOut() {
        emptyPool = true;
        System.out.println("warter out......" + Thread.currentThread().getName());
        notifyAll();
    }

    public synchronized void waiteOut() {
        while (!emptyPool) {
            try {
                System.out.println("==== out......" + Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                System.out.println("waterInWorking interrupted......");
            }
        }
    }

    public synchronized void waiteIn() {
        while (emptyPool) {
            try {
                System.out.println("==== in......");
                wait();
            } catch (InterruptedException e) {
                System.out.println("waterInWorking interrupted......");
            }
        }
    }


}

class WaterIn implements Runnable {
    private final WaterPool pool;

    public WaterIn(WaterPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pool.waterIn();
            pool.waiteOut();
        }
    }
}

class WaterOut implements Runnable {
    private final WaterPool pool;

    public WaterOut(WaterPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pool.waterOut();
            pool.waiteIn();
        }
    }
}