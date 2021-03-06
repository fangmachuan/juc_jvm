package com.longy.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: longy
 * @Date: 2020/12/26/12:01
 * @Description:
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 1; i <= 10; i++) {
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName()+"\t离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t班长关门走人");
    }

    private static void closeDoor() {
        for (int i = 1; i <= 10; i++) {
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName()+"\t离开教室");
            },String.valueOf(i)).start();
        }
        System.out.println(Thread.currentThread().getName()+"\t班长关门走人");
    }
}
