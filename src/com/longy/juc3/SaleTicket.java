package com.longy.juc3;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket{
    private Integer number=30;
    private Lock lock=new ReentrantLock();
    public void saleTicket(){
        lock.lock();
        try {
            if (number>0){
                System.out.println(Thread.currentThread().getName()+"\t 第:"+number--+"还有" +number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
/**
 * @author machuan
 * @create 2021-08-16 9:30 上午
 **/
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//
//            },String.valueOf(i)).start();
//        }for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//
//            },String.valueOf(i)).start();
//        }for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//
//            },String.valueOf(i)).start();
//        }

//        new Thread(() -> {
//
//        },"A").start();
//
//        new Thread(() -> {
//
//        },"B").start();
//
//        new Thread(() -> {
//
//        },"C").start();



//        new Thread(() ->{
//            for (int i = 0; i < 40; i++) {
//                ticket.saleTicket();
//            }
//        },"A").start();
//        new Thread(() ->{
//            for (int i = 0; i < 40; i++) {
//                ticket.saleTicket();
//            }
//        },"B").start();
//        new Thread(() ->{
//            for (int i = 0; i < 40; i++) {
//                ticket.saleTicket();
//            }
//        },"C").start();
    }
}
