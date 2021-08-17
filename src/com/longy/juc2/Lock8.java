package com.longy.juc2;




import java.util.concurrent.TimeUnit;

class Phone{
    public static synchronized void sendEmail() throws Exception{
        try {
            TimeUnit.SECONDS.sleep(4);
//            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendEmail");
    }

    public  synchronized void sendSMS() throws Exception{
        System.out.println("sendSMS");
    }

    public void hello(){
        System.out.println("hello");
    }
}

public class Lock8 {

    public static void main(String[] args) {

        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            try {
                phone.hello();
//                phone.sendSMS();
                phone2.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();


//        new Thread(() -> {
//            try {
////                phone.sendSMS();
////                phone2.hello();
//                phone2.sendSMS();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        },"C").start();
    }

}
