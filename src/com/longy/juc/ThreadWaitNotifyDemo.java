package com.longy.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 
class AirConditioner {//资源类
    private int number = 0;

    private int total = 0;

    private Lock lock = new ReentrantLock();
//    private Condition condition = lock.newCondition();
    private Condition condition=lock.newCondition();
    public int getNumber() {
        return number;
    }

    public void increment() {

        lock.lock();
        try {
            while (number != 0) {
                condition.await();//this.wait();
            }
            //2、干活
            number++;
            total++;
            System.out.println(Thread.currentThread().getName() + "\t现在的number为：" + number + "\t" + total);
            //3、通知
            condition.signalAll();//this.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            total++;
            condition.signalAll();
            System.out.println(Thread.currentThread().getName() + "\t现在的number为：" + number + "\t" + total);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }



//   public synchronized void increment() throws InterruptedException {
//       //1、判断
//       while (number != 0) {
//           this.wait();
//       }
//       //2、干活
//       number++;
//       total++;
//       System.out.println(Thread.currentThread().getName() + "\t现在的number为：" + number+"\t"+total);
//       //3、通知
//       this.notifyAll();
//   }
//
//    public synchronized void decrement() throws InterruptedException {
//        //1、判断
//        while (number == 0) {
//            this.wait();
//        }
//        //2、干活
//        number--;
//        total++;
//        System.out.println(Thread.currentThread().getName() + "\t现在的number为：" + number+"\t"+total);
//        //3、通知
//        this.notifyAll();
//    }
}

/**
 * 题目：现在有两个线程，可以操作初始值为零的一个变量，
 * 实现一个线程对该变量加一，一个线程对该变量减一，
 * 实现交替，来10轮，变量初始值为0。
 * <p>
 * 1.    高内聚前提下，线程操作资源类
 * 2.    判断/干活/通知
 * 3.    多线程交互中，必须要防止多线程虚假唤醒(判断用while，不能用if)
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) throws Exception {
        AirConditioner airConditioner = new AirConditioner();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    airConditioner.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    airConditioner.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    airConditioner.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();



        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    airConditioner.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "DD").start();

    }
}
