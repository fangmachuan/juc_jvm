package com.longy.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

class MyTask extends RecursiveTask<Integer>{
    private static final Integer ADJUST_VALUE = 10;

    private int begin;
    private int end;
    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        if ((end - begin) <= ADJUST_VALUE){
            for (int i = begin; i <= end ; i++) {
                result += i;
            }
        }else {
            int middle = (begin+end)/2;
            MyTask taskLeft = new MyTask(begin, middle);
            MyTask taskRight = new MyTask(middle+1, end);
            taskLeft.fork();//计算左边
            taskRight.fork();//计算右边

            result = taskLeft.join() + taskRight.join();

        }

        return result;
    }
}
/**
 * @Auther: longy
 * @Date: 2020/12/29/11:18
 * @Description: 分支合并框架
 *
 * ForkJoinPool
 * ForkJoinTask
 * RecursiveTask
 */
public class ForkJoinDemo {
    public static void main(String[] args) throws Exception {
        MyTask myTask = new MyTask(0, 100);

        ForkJoinPool threadPool = new ForkJoinPool();

        ForkJoinTask<Integer> forkJoinTask = threadPool.submit(myTask);

        System.out.println(forkJoinTask.get());
        threadPool.shutdown();
    }
}
