package com.atguigu.juc.volatiles;

import java.util.concurrent.TimeUnit;

/**
 * Author Yjw
 * 2022/11/28 14:53
 */
public class VolatileSeeDemo {

    static volatile boolean flag = true;
    //static  boolean flag = true;

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t -----come in");
            while (flag) {

            }
            System.out.println(Thread.currentThread().getName() + "\t -----flag被修改，线程终止");
        }, "t1").start();

        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }

        flag = false;

        System.out.println(Thread.currentThread().getName() + "\t -----flag修改完成 " + flag);
    }
}
