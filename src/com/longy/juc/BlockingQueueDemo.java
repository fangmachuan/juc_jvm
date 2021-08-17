package com.longy.juc;




import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: longy
 * @Date: 2020/12/28/14:36
 * @Description:
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.add("c"));
////        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.element());
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("b"));
//        System.out.println(blockingQueue.offer("c"));//插入成功true失败false
//        System.out.println(blockingQueue.offer("c"));
//        System.out.println(blockingQueue.poll());//移除成功true失败false
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        blockingQueue.put("a");
//        blockingQueue.put("a");
//        blockingQueue.put("a");
//        blockingQueue.put("a");
//
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.offer("a",3L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b",3L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c",3L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c",3L, TimeUnit.SECONDS));


    }
}
