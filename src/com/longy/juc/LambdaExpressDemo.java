package com.longy.juc;

@FunctionalInterface
interface Foo {
    public void sayHello();

    default int div(int x,int y){
        System.out.println("div");
        return x/y;
    };

    public static int mv(int x, int y) {
    return x*y;
    }
    public static int mv2(int x, int y) {
    return x*y;
    }
}

/**
 * 1 Lambda ExpressDemo
 * 1.1 速记口诀 拷贝小括号，写死右箭头，落地大括号
 *
 * 1.2 @FunctionalInterface(默认一个方法的时候，自动加上)
 *
 * 1.3 default
 *
 * 1.4 静态方法实现
 */
public class LambdaExpressDemo {
    public static void main(String[] args) {
       Foo foo = () ->{
           System.out.println("hello");
       };
       foo.sayHello();

        System.out.println(foo.div(10, 5));

        System.out.println(Foo.mv(2 ,5));
    }
}
