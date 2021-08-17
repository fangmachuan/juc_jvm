package com.longy.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MyThreadRunnable implements Runnable {

    @Override
    public void run() {

    }
}

class MyThreadCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("***************come in MyThreadCallable");

        Thread.sleep(4000);
        return 1024;
    }
}


/**
 * @Auther: longy
 * @Date: 2020/12/26/10:28
 * @Description: 多线程中，第三种获得多线程的方式
 */
public class CallableDemo {
    public static void main(String[] args) throws Exception {

        FutureTask futureTask = new FutureTask<>(new MyThreadCallable());
        new Thread(futureTask, "AA").start();
        new Thread(futureTask, "BB").start();


        System.out.println(Thread.currentThread().getName()+"计算完成");
        System.out.println(futureTask.get());

        // Thread(Runnable target,string name)
        // Thread(Callable target,string name)
    }
}
