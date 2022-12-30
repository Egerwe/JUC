package com.atguigu.juc.atomics;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Author Yjw
 * 2022/12/5 16:18
 */

class BankAccount {
    String bankName = "CCB";

    public volatile int money = 0;

    public void add() {
        money++;
    }

    AtomicIntegerFieldUpdater<BankAccount> fieldUpdater =
            AtomicIntegerFieldUpdater.newUpdater(BankAccount.class, "money");
    //不加synchronized
    public void safeAdd(BankAccount bankAccount) {
        fieldUpdater.getAndIncrement(bankAccount);
    }
}
public class AtomicIntegerFieldUpdaterDemo {
    public static void main(String[] args) throws InterruptedException {

        BankAccount bankAccount = new BankAccount();
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 1000; j++) {
                        //bankAccount.add();
                        bankAccount.safeAdd(bankAccount);
                    }
                } finally {
                    countDownLatch.countDown();
                }
            }, "t1").start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t" + bankAccount.money);
    }
}
