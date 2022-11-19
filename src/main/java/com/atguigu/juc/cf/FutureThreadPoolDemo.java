package com.atguigu.juc.cf;

import javax.swing.event.TreeSelectionListener;
import java.util.concurrent.*;

/**
 * Author Yjw
 * 2022/11/17 21:48
 */
public class FutureThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long startTime = System.currentTimeMillis();

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        FutureTask<String> futureTask1 = new FutureTask<String>(() -> {
            try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
            return "task1 over";
        });
        threadPool.submit(futureTask1);

        FutureTask<String> futureTask2 = new FutureTask<String>(() -> {
            try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
            return "task1 over";
        });
        threadPool.submit(futureTask2);

        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());
        try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }

        threadPool.shutdown();

        long endTime = System.currentTimeMillis();
        System.out.println("---costTime: " + (endTime - startTime) + "毫秒");
    }

    public static void m1() {
        long startTime = System.currentTimeMillis();

        try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
        try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
        try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }


        long endTime = System.currentTimeMillis();
        System.out.println("---costTime: " + (endTime - startTime) + "毫秒");

        System.out.println(Thread.currentThread().getName() + "\t -----end");
    }
}
