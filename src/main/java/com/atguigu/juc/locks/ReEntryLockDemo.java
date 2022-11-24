package com.atguigu.juc.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author Yjw
 * 2022/11/20 22:23
 */
public class ReEntryLockDemo {

    public synchronized void m1() {

        System.out.println(Thread.currentThread().getName() + "\t -----come in");
        m2();
        System.out.println(Thread.currentThread().getName() + "\t -----end m1");
    }

    public synchronized void m2() {
        System.out.println(Thread.currentThread().getName() + "\t -----come in");
        m3();
    }

    public synchronized void m3() {
        System.out.println(Thread.currentThread().getName() + "\t -----come in");
    }

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

       /* ReEntryLockDemo reEntryLockDemo = new ReEntryLockDemo();

        new Thread(() -> {
            reEntryLockDemo.m1();
        }, "t1").start();*/

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t-----come in外层调用   ");
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "\t-----come in内层调用   ");
                } finally {
                    lock.unlock();
                }
            } finally {
                //lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t-----come in外层调用   ");
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }

    public static void reEntryM1() {
        final Object object = new Object();
        new Thread(() -> {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "\t -----外层调用");
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + "\t -----中层调用");
                    synchronized (object) {
                        System.out.println(Thread.currentThread().getName() + "\t -----内层调用");
                    }
                }
            }
        }, "t1").start();
    }
}
