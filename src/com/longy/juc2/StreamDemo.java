package com.longy.juc2;


import java.util.Arrays;
import java.util.List;
import java.util.Locale;

class User{
    private Integer id;
    private String userName;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(Integer id, String userName, Integer age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }
}

public class StreamDemo {

    public static void main(String[] args) {
        User user1 = new User(1,"a",22);
        User user2 = new User(2,"b",23);
        User user3 = new User(3,"c",25);
        User user4 = new User(4,"d",26);
        User user5 = new User(6,"e",28);
        List<User> list= Arrays.asList(user1,user2,user3,user4,user5);

        list.stream().filter(user -> {return user.getId()%2==0;})
                .filter(user -> {return user.getAge()>25;})
                .map(m->{
                    return m.getUserName().toUpperCase(Locale.ROOT);
                })
//                .sorted()
                .sorted((o1, o2) -> {return o2.compareTo(o1);})
                .limit(1)
                .forEach(System.out::println);

//        List<Integer> list1 = Arrays.asList(1, 2, 3);
//        List<Integer> list2 = list1.stream().map(x -> {
//            return x * 2;
//        }).collect(Collectors.toList());
//        for (Integer element : list2) {
//            System.out.println(element);
//
//        }


//        Function<String,Integer> function=new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return null;
//            }
//        };
//        Function<String,Integer> function= s->{return s.length();};
//        System.out.println(function.apply("qwe"));



//        Predicate<String> predicate=new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return false;
//            }
//        };
//        Predicate<String > predicate=s->{return true;};
//        System.out.println(predicate.test("Predicate==sadasd"));



//        Consumer<String> consumer=new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//
//            }
//        };
//        Consumer<String> consumer=s->{
//            System.out.println(s);
//        };
//        consumer.accept("consumer==asdasdsa");



//        Supplier<String> supplier=new Supplier<String>() {
//            @Override
//            public String get() {
//                return null;
//            }
//        };
//        Supplier supplier=()->{return "Supplier==java";};
//        System.out.println(supplier.get());


    }

}
