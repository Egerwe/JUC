package com.atguigu.juc.cas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Author Yjw
 * 2022/11/29 15:38
 */

@Getter
@ToString
@AllArgsConstructor
class User {
    String userName;
    int    age;
}

public class AtomicReferenceDemo {
    public static void main(String[] args) {
        AtomicReference<User> userAtomicReference = new AtomicReference<>();

        User z3 = new User("z3", 22);
        User l4 = new User("l4", 28);

        userAtomicReference.set(z3);
        System.out.println(userAtomicReference.compareAndSet(z3, l4) + "\t" + userAtomicReference.get());
        System.out.println(userAtomicReference.compareAndSet(z3, l4) + "\t" + userAtomicReference.get());
    }
}
