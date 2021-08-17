package com.longy.juc2;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
//            System.out.println(Thread.currentThread().getName() + "\t 没有返回");
//        });
//        completableFuture.get();
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t ");
//            int age=10/0;
            return 1024;
        });
        System.out.println(completableFuture1.whenComplete((t, u) -> {
            System.out.println("t-----" + t);
            System.out.println("u----" + u);
        }).exceptionally(f -> {
            System.out.println("exception" + f.getMessage());
            return 4444;
        }).get());


    }



}
