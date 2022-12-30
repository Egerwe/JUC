package com.atguigu.juc.atomics;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Author Yjw
 * 2022/12/5 16:29
 */
class MyCar {
    public volatile Boolean isInit = Boolean.FALSE;

    AtomicReferenceFieldUpdater<MyCar, Boolean> referenceFieldUpdater =
            AtomicReferenceFieldUpdater.newUpdater(MyCar.class, Boolean.class, "isInit");

    public void init(MyCar myCar) {
        if (referenceFieldUpdater.compareAndSet(myCar, Boolean.FALSE, Boolean.TRUE)) {
            System.out.println(Thread.currentThread().getName() + "\t" + "----- start init,need 3 seconds");
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName() + "\t" + "----- over init");
        } else {
            System.out.println(Thread.currentThread().getName() + "\t" + "-----已经有线程在进行初始化工作。。。");
        }
    }
}

public class AtomicReferenceFieldUpdaterDemo {
    public static void main(String[] args) {
        MyCar myCar = new MyCar();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                myCar.init(myCar);
            }, String.valueOf(i)).start();
        }
    }
}
