package com.longy.juc2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

class MyTask extends RecursiveTask<Integer>{

    private static final Integer ADJUST_VALUE=10;
    private int begin;
    private int end;
    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if ((end-begin)<=ADJUST_VALUE){

            for (int i = begin; i <=end; i++) {
                result=result+i;
            }
            return result;
        }else {
            int middle=(end+begin)/2;
            MyTask taskLeft = new MyTask(begin, middle);
            MyTask taskRight = new MyTask(middle+1, end);
            taskLeft.fork();//计算左边
            taskRight.fork();//计算右边
            result=taskLeft.join()+taskRight.join();
            return result;
        }

    }
}

public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyTask myTask = new MyTask(0,100);
        ForkJoinPool threadPool = new ForkJoinPool();

        ForkJoinTask<Integer> forkJoinTask = threadPool.submit(myTask);

        System.out.println(forkJoinTask.get());

        threadPool.shutdown();
    }
}
