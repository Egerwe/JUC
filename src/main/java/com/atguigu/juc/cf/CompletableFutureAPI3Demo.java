package com.atguigu.juc.cf;

import java.util.concurrent.CompletableFuture;

/**
 * Author Yjw
 * 2022/11/19 20:06
 */
public class CompletableFutureAPI3Demo {
    public static void main(String[] args) {
//        CompletableFuture.supplyAsync(() -> {
//            return 1;
//        }).thenApply(f -> {
//            return f + 2;
//        }).thenApply(f -> {
//            return f + 3;
//        }).thenAccept(System.out::println);
        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenRun(() -> {}).join());
        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenAccept(r -> {System.out.println(r);}).join());
        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenApply(r -> r + "resultB").join());

    }
}
