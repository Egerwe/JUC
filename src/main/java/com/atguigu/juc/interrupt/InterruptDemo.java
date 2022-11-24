package com.atguigu.juc.interrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Author Yjw
 * 2022/11/24 21:16
 */
public class InterruptDemo {

    static volatile boolean isStop = false;
    static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "\t isInterrupted()被修改，程序终止");
                    break;
                }
                System.out.println("t1 -------hello interrupt api");
            }
        }, "t1");
        t1.start();
        try { TimeUnit.MILLISECONDS.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
        t1.interrupt();
    }

    public static void m2_atomicBollen() {
        new Thread(() -> {
            while (true) {
                if (atomicBoolean.get()) {
                    System.out.println(Thread.currentThread().getName() + "\t atomicBoolean被修改，程序终止");
                    break;
                }
                System.out.println("t1 -------hello atomicBoolean");
            }
        }, "t1").start();

        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            atomicBoolean.set(true);
        }, "t2").start();
    }

    public static void m1_volatile() {
        new Thread(() -> {
            while (true) {
                if (isStop) {
                    System.out.println(Thread.currentThread().getName() + "\t isStop被修改，程序终止");
                    break;
                }
                System.out.println("t1 -------hello volatile");
            }
        }, "t1").start();

        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            isStop = true;
        }, "t2").start();
    }
}
