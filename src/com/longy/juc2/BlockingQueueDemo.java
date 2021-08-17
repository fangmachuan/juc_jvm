package com.longy.juc2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
//        Collection
//
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);


//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.add("c"));
//
////        System.out.println(blockingQueue.add("d"));
//
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());

//        blockingQueue.add("a");
//        blockingQueue.add("b");
//        blockingQueue.add("c");
//        System.out.println(blockingQueue.element());

        //-----------------------------
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("b"));
//        System.out.println(blockingQueue.offer("c"));
////        System.out.println(blockingQueue.offer("d"));
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());

//        blockingQueue.put("a");
//        blockingQueue.put("a");
//        blockingQueue.put("a");
//
////        blockingQueue.put("a");
//
//        blockingQueue.take();
//        blockingQueue.take();
//        blockingQueue.take();
////        blockingQueue.take();

        System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));



    }
}
