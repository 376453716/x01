package com.xh.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xh on 11/03/16.
 */
public class DeathLockTest {

    public static void test1() throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        final TreeNode parent = new TreeNode();
        final TreeNode child = new TreeNode();
        service.submit(new Runnable() {
            @Override
            public void run() {
                parent.addChild(child);
            }
        });
        service.submit(new Runnable() {
            @Override
            public void run() {
                child.setParent(parent);
            }
        });
    }

    public static void test2() throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        final LockTreeNode parent = new LockTreeNode();
        final LockTreeNode child = new LockTreeNode();
        service.submit(new Runnable() {
            @Override
            public void run() {
                parent.addChild(child);
            }
        });
        service.submit(new Runnable() {
            @Override
            public void run() {
                child.setParent(parent);
            }
        });
    }

    public static void main(String[] args) throws Exception {
//        test1();
        test2();
    }

}

/**
 * Node1 parent
 * Node2 child
 * Thread1 Thread2
 * Thread1  parent add child
 * thread2 child set parent
 * thread1 lock parent add child,then try lock child to set child  this parent
 * thread2 lock child set parent, then try lock parent to add this child
 */
class TreeNode {

    private TreeNode parent;

    private List<TreeNode> children = new ArrayList<TreeNode>();

    public synchronized void addChild(TreeNode child) {
        if (!children.contains(child)) {
            children.add(child);
            child.setParentOnly(this);
            System.out.println("add child done.");
        }
    }

    public synchronized void setParent(TreeNode parent) {
        this.parent = parent;
        parent.addChildOnly(this);
        System.out.println("set parent done.");
    }

    public synchronized void addChildOnly(TreeNode child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    public synchronized void setParentOnly(TreeNode parent) {
        this.parent = parent;
    }

}

class LockTreeNode {
    Lock lock = new ReentrantLock();
    private LockTreeNode parent;
    private List<LockTreeNode> children = new ArrayList<LockTreeNode>();

    public void addChild(LockTreeNode child) {
        boolean done = false;
        boolean lockedThis = false;
        while (!done) {
            try {
                lockedThis = lock.tryLock();
                if (lockedThis) {
                    if (!children.contains(child)) {
                        children.add(child);
                        done = child.setParentOnly(this);
                    }
                }
            } finally {
                lock.unlock();
            }
            if (!done) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("addChild done==" + done + "----lockedThis=" + lockedThis);
        }
    }

    public void setParent(LockTreeNode parent) {
        boolean done = false;
        boolean lockedThis = false;
        while (!done) {
            try {
                lockedThis = lock.tryLock();
                if (lockedThis) {
                    this.parent = parent;
                    done = parent.addChildOnly(this);
                }
            } finally {
                if (lockedThis)
                    lock.unlock();
            }
            if (!done) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("setParent done==" + done + "----lockedThis=" + lockedThis);
    }

    public boolean addChildOnly(LockTreeNode child) {
        boolean locked = lock.tryLock();
        try {
            if (!children.contains(child)) {
                children.add(child);
            }
        } finally {
            if (locked)
                lock.unlock();
        }
        return locked;
    }

    public boolean setParentOnly(LockTreeNode parent) {
        boolean done = false;
        try {
            done = lock.tryLock(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            if (done)
                this.parent = parent;
        } finally {
            if (done)
                lock.unlock();
        }
        return done;
    }


}


