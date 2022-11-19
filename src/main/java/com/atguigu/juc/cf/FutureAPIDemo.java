package com.atguigu.juc.cf;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Author Yjw
 * 2022/11/17 22:02
 */
public class FutureAPIDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<String> futureTask = new FutureTask<String>(() -> {
            System.out.println(Thread.currentThread().getName()+"\t -----come in");
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            return "task over";
        });

        Thread t1 = new Thread(futureTask, "t1");
        t1.start();

        System.out.println(Thread.currentThread().getName() + "\t -----忙其它任务了");

        //System.out.println(futureTask.get());阻塞
        //System.out.println(futureTask.get(3, TimeUnit.SECONDS));
        while (true) {
            if (futureTask.isDone()) {
                System.out.println(futureTask.get());
                break;
            } else {
                try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println("正在处理中，不要再催了");
            }
        }
    }
}
