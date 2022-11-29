package com.atguigu.juc.cas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Author Yjw
 * 2022/11/29 16:04
 */
@Getter
@ToString
@AllArgsConstructor
class Book {
    private int id;
    private String bookName;
}

public class AtomicStampedDemo {
    public static void main(String[] args) {

        Book javaBook = new Book(1, "javaBook");
        Book mysqlBook = new Book(1, "mysqlBook");
        AtomicStampedReference<Book> bookAtomicStampedReference = new AtomicStampedReference<>(javaBook, 1);

        System.out.println(bookAtomicStampedReference.getReference() + "\t" + bookAtomicStampedReference.getStamp());

        boolean result;
        result = bookAtomicStampedReference.compareAndSet(javaBook, mysqlBook, bookAtomicStampedReference.getStamp(),
                bookAtomicStampedReference.getStamp() + 1);
        System.out.println(result + " \t" + bookAtomicStampedReference.getReference() + "\t" +
                bookAtomicStampedReference.getStamp());

        result = bookAtomicStampedReference.compareAndSet(mysqlBook, javaBook, bookAtomicStampedReference.getStamp(),
                bookAtomicStampedReference.getStamp() + 1);
        System.out.println(result + " \t" + bookAtomicStampedReference.getReference() + "\t" +
                bookAtomicStampedReference.getStamp());



    }
}
