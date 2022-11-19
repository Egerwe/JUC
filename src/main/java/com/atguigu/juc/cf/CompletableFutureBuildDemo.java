package com.atguigu.juc.cf;

import java.util.concurrent.*;

/**
 * Author Yjw
 * 2022/11/18 10:19
 */
public class CompletableFutureBuildDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        /*CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        }, threadPool);
        System.out.println(completableFuture.get());*/

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            return "hello supplyAsync";
        }, threadPool);
        System.out.println(completableFuture.get());
        threadPool.shutdown();
    }
}
