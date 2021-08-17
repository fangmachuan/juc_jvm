package com.longy.jvm;

class Mynumber{
    volatile int number=1;

    public void add(){
        this.number=1024;
    }
}


public class JVMMote {

    static int a=0;

    public int add(){
        return 1;
    }

    public static void m1(){

    }


    public static void main(String[] args) {


        Mynumber Mynumber = new Mynumber();
        new Thread(() -> {
            System.out.println("A coming");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            Mynumber.add();
            System.out.println(Thread.currentThread().getName()+"\t 第Acomin:"+Mynumber.number);
        },"A").start();


        while (Mynumber.number==1){
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"\t 第main voer");




//        System.out.println(Runtime.getRuntime().freeMemory());
//        System.out.println(Runtime.getRuntime().maxMemory());
//        String str="a";
////        System.out.println(str = str + "b");
//
//        System.out.println(str += str + "b");
//        System.out.println("===");
//        System.out.println(str = str + "b");
//
//        System.gc();
//        while (true){
//            str+=str+new Random().nextInt(99999)+new Random().nextInt(111111);
//        }
//        Byte[] bytes=new Byte[20*1024*1024];

    }
}
