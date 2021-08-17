package com.longy.juc;

/**
 * @Auther: longy
 * @Date: 2020/12/28/15:10
 * @Description:
 */
public class Person {
    private int id;
    private String personName;

    public Person(String personName) {
        this.personName = personName;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
