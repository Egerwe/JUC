package com.atguigu.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author Yjw
 * 2022/11/29 15:07
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 2022) + "\t" +  atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2022) + "\t" +  atomicInteger.get());

        System.out.println(atomicInteger.getAndIncrement() + "\t" + atomicInteger.get());
    }
}
