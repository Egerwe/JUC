package com.atguigu.juc.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Author Yjw
 * 2022/11/19 20:45
 */
public class CompletableFutureCombineDemo2 {
    public static void main(String[] args) {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " come in");
            return 10;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " come in");
            return 20;
        }), (x, y) -> {
            System.out.println(Thread.currentThread().getName() + " come in");
            return x + y;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " come in");
            return 30;
        }), (x, y) -> {
            System.out.println(Thread.currentThread().getName() + " come in");
            return x + y;
        });

        System.out.println(completableFuture.join());
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

    }
}
