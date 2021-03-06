package com.longy.juc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 题目：请举例说明集合类是不安全的
 * 1. 故障现象  java.util.ConcurrentModificationException
 *
 * 2. 导致原因
 *
 * 3.解决方案
 *  3.1  Vector
 *  3.2  Collections.synchronizedList(new ArrayList<>())
 *  3.3  CopyOnWriteArrayList
 *
 * 4.优化建议（同样的错误，不出现第二次）
 */
public class NotSafeDemo {
    public static void main(String[] args) throws InterruptedException {
       NotSafeList();
    }



    private static void ConcurrentHash() {
        Map<String, String> map = new ConcurrentHashMap<>();//Collections.synchronizedMap(new HashMap<>());//new HashMap<>();
        for (int i = 0; i < 300; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName()/*"i"写死不报错*/,UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName()+"\t"+map);
            }, String.valueOf(i)).start();
        }
    }



    private static void NotSafeSet() {
        Set<Object> set = new CopyOnWriteArraySet<>();//Collections.synchronizedSet(new HashSet<>()); //new HashSet<>();
        for (int i = 0; i < 300; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName()+"\t"+set);
            }, String.valueOf(i)).start();
        }
    }

    private static void NotSafeList() {
        List<String> list = new CopyOnWriteArrayList<>();//Collections.synchronizedList(new ArrayList<>());//Vector<>();//ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName()+"\t"+list);
            }, String.valueOf(i)).start();
        }
    }
}

/**
 * 写时复制
 *  Copyonwrite容器即写时复制的容器。往一个容器添加元素的时候，不直接往当前容器object[]添加，而是先将当前容Object[]进行copy，
 * 复制出一个新的容器object[ ] newELements，然后新的容器object[ ] newELements里添加元素，添加完元素之后，
 * 再将原容器的引用指向新的容器setArray(newELements);。这样做的好处是可以对CopyOnlrite容器进行并发的读，
 * 而不需要加锁，因为当前容器不会添加任何元素。所以CopyOnwrite容器也是一种读写分离的思想，读和写不同的容器
 *
 * 源码：
 *     public boolean add(E e) {
 *         final ReentrantLock lock = this.lock;
 *         lock.lock();
 *         try {
 *             Object[] elements = getArray();
 *             int len = elements.length;
 *             Object[] newElements = Arrays.copyOf(elements, len + 1);
 *             newElements[len] = e;
 *             setArray(newElements);
 *             return true;
 *         } finally {
 *             lock.unlock();
 *         }
 *     }
 */