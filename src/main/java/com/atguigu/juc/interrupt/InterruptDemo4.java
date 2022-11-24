package com.atguigu.juc.interrupt;

/**
 * Author Yjw
 * 2022/11/24 22:38
 */
public class InterruptDemo4 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());

        System.out.println("--------1");
        Thread.currentThread().interrupt();
        System.out.println("--------2");

        System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());
    }
}
