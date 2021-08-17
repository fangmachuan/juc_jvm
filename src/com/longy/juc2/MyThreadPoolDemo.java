package com.longy.juc2;

import java.util.concurrent.*;

public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2, 5,
                2L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
//        System.out.println(Runtime.getRuntime().availableProcessors());cpu密集：核数+1，，io密集



        try {
            for (int i = 1; i<11; i++) {

                threadPool.execute(()->{
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"\t ");

                });

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }


    }


    private static void SysThreadPoolExcuutor() {
        ExecutorService threadPool =Executors.newFixedThreadPool(5);
//        ExecutorService threadPool =Executors.newSingleThreadExecutor();
//        ExecutorService threadPool = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadPool.execute(()->{

                    System.out.println(Thread.currentThread().getName()+"\t ");

                });

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
