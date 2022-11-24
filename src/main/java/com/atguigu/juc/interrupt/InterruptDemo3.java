package com.atguigu.juc.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * Author Yjw
 * 2022/11/24 22:23
 */
public class InterruptDemo3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "线程 ----- isInterrupted() = true,自己退出了");
                    break;
                }
                try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

                System.out.println("----- hello InterruptDemo3");
            }
        }, "t1");
        t1.start();
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        t1.interrupt();
    }
}
