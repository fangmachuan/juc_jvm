package com.longy.juc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class User {
    private int id;
    private String userName;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    public User(int id, String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}

/**
 * @Auther: longy
 * @Date: 2020/12/28/17:12
 * @Description: 题目:请按照给出数据，找出同时满足以下条件的用户,也即以下条件全部满足
 * 偶数ID且年龄大于24且用户名转为大写且用户名字母倒排序
 * 只输出一个用户名字
 */
public class StreamDemo {
    public static void main(String[] args) {
        User u1 = new User(11, "a", 23);
        User u2 = new User(12, "b", 24);
        User u3 = new User(13, "c", 22);
        User u4 = new User(14, "d", 28);
        User u5 = new User(16, "e", 26);
        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);

        list.stream().filter(user -> {
            return user.getId() % 2 == 0;//偶数ID
        }).filter(user -> {
            return user.getAge() > 24;//年龄大于24
        }).map(user -> {
            return user.getUserName().toUpperCase();//转换为大写
        }).sorted((o1, o2) -> {
            return o2.compareTo(o1);//排序倒叙排列
        }).limit(1).forEach(System.out::println);

//=========================================================
        List<User> users = list.stream().filter(user -> {
            return user.getId() % 2 == 0;
        }).filter(user -> {
            return user.getAge() > 24;
        }).map(user -> {
            user.setUserName(user.getUserName().toUpperCase());
            return user;
        }).sorted((user1,user2) ->{
            return user2.getUserName().compareTo(user1.getUserName());
        }).limit(1).collect(Collectors.toList());

        for (User user : users) {
            System.out.println(user);
        }


        //=============================================================
//        //函数型接口
//        Function<String/*传入参数*/,Integer/*返回参数*/> function = s->{
//            return s.length();
//        };
//        System.out.println(function.apply("longy"));
//
//        //断定型接口
//        Predicate<String/*传入参数，返回boolean*/> predicate = s -> {
//            return s.equals("a");
//        };
//        System.out.println(predicate.test("a"));
//
//        //消费型接口
//        Consumer<Integer> consumer = n -> {
//            System.out.println(n);
//        };
//        consumer.accept(12);
//
//        Supplier<String> supplier = () ->{
//            return "supplier";
//        };
//        System.out.println(supplier.get());


    }

    interface MyInterface {
        public int myInt(int x);

        public String myString(String str);
    }
}
