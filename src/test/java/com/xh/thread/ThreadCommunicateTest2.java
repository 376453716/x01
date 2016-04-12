package com.xh.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xh on 10/03/16.
 */
public class ThreadCommunicateTest2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        WaterPool pool = new WaterPool();
        executorService.submit(new WaterIn(pool));
        //executorService.submit(new WaterIn(pool));
        executorService.submit(new WaterOut(pool));
    }


    static class WaterPool {
        private boolean emptyPool = true;
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        public void waterIn() {
            lock.lock();
            emptyPool = false;
            System.out.println("warter in......" + Thread.currentThread().getName());
            condition.signalAll();
            lock.unlock();
        }

        public void waterOut() {
            lock.lock();
            emptyPool = true;
            System.out.println("warter out......" + Thread.currentThread().getName());
            condition.signalAll();
            lock.unlock();
        }


        public void waiteOut() {
            lock.lock();
            while (!emptyPool) {
                try {
                    System.out.println("==== out......" + Thread.currentThread().getName());
                    condition.await();
                } catch (InterruptedException e) {
                    System.out.println("waterInWorking interrupted......");
                }
            }
            lock.unlock();

        }

        public void waiteIn() {
            lock.lock();
            while (emptyPool) {
                try {
                    System.out.println("==== in......");
                    condition.await();
                } catch (InterruptedException e) {
                    System.out.println("waterInWorking interrupted......");
                }
            }
            lock.unlock();
        }


    }

    static class WaterIn implements Runnable {
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

    static class WaterOut implements Runnable {
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

}