package com.longy.juc2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread1 implements Runnable{

    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {

        System.out.println("come in here");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1024;
    }
}


public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        MyThread2 myThread = new MyThread2();
//        Thread thread = new Thread(myThread);
//        thread.start();

        FutureTask futureTask=new FutureTask(new MyThread2());
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();//futureTask只会调用一次，结果会在缓存中
//        System.out.println(futureTask.get());
        System.out.println("main");
        System.out.println(futureTask.get());

    }

}
