package com.atguigu.juc.locks;

import java.util.concurrent.TimeUnit;

/**
 * Author Yjw
 * 2022/11/19 21:12
 */
public class Lock8Demo {
    public static void main(String[] args) {

        Phone iphone = new Phone();
        Phone iphone2 = new Phone();
        new Thread(() -> {
            iphone.sendEmail();
        }, "a").start();

        try { TimeUnit.MILLISECONDS.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(() -> {
            iphone2.sendMsg();
            //iphone.hello();
            //iphone2.sendMsg();
        }, "b").start();
    }
}
class Phone{
    public static synchronized void sendEmail() {
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("------sendEmail");
    }
    public synchronized void sendMsg() {
        System.out.println("------sendMsg");
    }
    public void hello() {
        System.out.println("------hello");
    }
}