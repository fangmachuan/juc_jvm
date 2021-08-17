package com.longy.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 
class Ticket {//资源类
    private int number = 30;
    Lock lock = new ReentrantLock();

    public void saleTicket() {

        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出第：" + (number--) + "\t还剩下" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}

/**
 * 多线程编程企业级套路+模板
 * <p>
 * 1、在高内聚低耦合的前提下， 线程     操作（对外暴露操作方法）     资源类
 */
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(() ->{
            for (int i = 0; i < 40; i++) {
                    ticket.saleTicket();
                }
        },"A").start();
        new Thread(() ->{
            for (int i = 0; i < 40; i++) {
                    ticket.saleTicket();
                }
        },"B").start();
        new Thread(() ->{
            for (int i = 0; i < 40; i++) {
                    ticket.saleTicket();
                }
        },"C").start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 400; i++) {
//
//                    ticket.saleTicket();
//                }
//            }
//        }, "AA").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 400; i++) {
//
//                    ticket.saleTicket();
//                }
//            }
//        }, "BB").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 400; i++) {
//
//                    ticket.saleTicket();
//                }
//            }
//        }, "CC").start();
    }
}
