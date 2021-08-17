package com.longy.juc;

/**
 * @Auther: longy
 * @Date: 2020/12/28/15:12
 * @Description:
 */
public class TestTransferValue {
    public void changeValue1(int age){
        age = 30;
    }
    public void changeValue2(Person person){
        person.setPersonName("xxx");
    }
    public void changeValue3(String str){
        str = "xxx";
    }

    public static void main(String[] args) {
        TestTransferValue test = new TestTransferValue();
        int age =20;
        test.changeValue1(age);
        System.out.println("age----->"+age);

        Person person = new Person("jack");
        test.changeValue2(person);
        System.out.println("personName---->"+person.getPersonName());

        String str = "abc";
        test.changeValue3(str);
        System.out.println("string---->"+str);
    }
}
