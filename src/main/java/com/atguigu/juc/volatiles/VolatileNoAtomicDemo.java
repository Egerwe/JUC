package com.atguigu.juc.volatiles;

class MyNumber {
    int number;

    public synchronized void addPlusPlus() {
        number++;
    }
}
/**
 * Author Yjw
 * 2022/11/28 15:37
 */
public class VolatileNoAtomicDemo {

}
