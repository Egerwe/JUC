package com.atguigu.juc.locks;

/**
 * Author Yjw
 * 2022/11/19 22:17
 */
public class LockSyncDemo {

/*    Object object = new Object();

    public void m1() {
        synchronized (object) {
            System.out.println("---hello synchronized code block");
        }
    }*/

    public synchronized void m2() {
        System.out.println("---hello synchronized m2");
    }

    public static synchronized void m3() {
        System.out.println("---hello static synchronized m3");
    }

    public static void main(String[] args) {

    }
}
