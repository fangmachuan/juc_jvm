package com.longy.juc2;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AirConditioner{
    private int number=0;


    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();

    public   void  increment() throws InterruptedException {

        lock.lock();
        try {
            while (number!=0){
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"\t 第:"+number);
            condition.signalAll();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }

    public  void decrement() throws InterruptedException {
        lock.lock();
        try {

            while (number==0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t 第:"+number);
            condition.signalAll();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

//    public synchronized  void  increment() throws InterruptedException {
//        while (number!=0){
//            this.wait();
//        }
//        number++;
//        System.out.println(Thread.currentThread().getName()+"\t 第:"+number);
//        this.notifyAll();
//    }
//
//    public synchronized void decrement() throws InterruptedException {
//        while (number==0){
//            this.wait();
//        }
//        number--;
//        System.out.println(Thread.currentThread().getName()+"\t 第:"+number);
//        this.notifyAll();
//    }





}

public class ThreadWaitNotifyDemo {

    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();

        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                try {
                    Thread.sleep(200);
                    airConditioner.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                try {
                    Thread.sleep(200);
                    airConditioner.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                try {
                    Thread.sleep(200);
                    airConditioner.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                try {
                    Thread.sleep(200);
                    airConditioner.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();

    }


}
