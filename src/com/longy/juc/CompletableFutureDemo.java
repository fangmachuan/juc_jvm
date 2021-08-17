package com.longy.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Auther: longy
 * @Date: 2020/12/29/16:18
 * @Description:
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "没有返回值，Mysql update... ok");
        });

        //异步回调
        CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "返回值Integer，Mysql insert... ok");
            int i =10 /0;
            return 1;
        });

        System.out.println(supplyAsync.whenComplete((t, o) -> {
            System.out.println("t:" + t);
            System.out.println("o:" + o);
        }).exceptionally(f -> {
            System.out.println(f.getMessage());
            return 4444;
        }).get());
    }
}
