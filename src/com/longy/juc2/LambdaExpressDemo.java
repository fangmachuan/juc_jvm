package com.longy.juc2;



//@FunctionalInterface
interface Foo{
//    public void sayHello();
    public int add(int x ,int y);

    default int div(int x,int y){
        System.out.println("hello");
        return x/y;
    }

    public static int mv(int x,int y){
        return x*y;
    }

}

public class LambdaExpressDemo {
    public static void main(String[] args) {
//        Foo foo = new Foo() {
//            @Override
//            public void sayHello() {
//                System.out.println("hello");
//            }
//        };
//        Foo foo=()->{
//            System.out.println("hello");
//        };
//        foo.sayHello();
        Foo foo=( x, y)->{
            System.out.println("hello");
            return x+y;
        };
        System.out.println(foo.add(3, 9));

        System.out.println(foo.div(10,5));
        System.out.println(Foo.mv(10,5));

    }
}
