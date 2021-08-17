package com.longy.jvm;

public class MyObject {

    public static void main(String[] args) {
        Object o = new Object();
//        System.out.println(o.getClass().getClassLoader().getParent().getParent());
//        System.out.println(o.getClass().getClassLoader().getParent());
        System.out.println(o.getClass().getClassLoader());
//



        MyObject myObject = new MyObject();
//        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());
        System.out.println(myObject.getClass().getClassLoader().getParent());
        System.out.println(myObject.getClass().getClassLoader());

        Thread thread = new Thread();
        thread.start();
        thread.start();//Exception in thread "main" java.lang.IllegalThreadStateException

    }
}
