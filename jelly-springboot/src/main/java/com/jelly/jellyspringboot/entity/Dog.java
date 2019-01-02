package com.jelly.jellyspringboot.entity;

public class Dog {
    private String nick;

    @Override
    public String toString() {
        return "Dog{" +
                "nick='" + nick + '\'' +
                ", age=" + age +
                '}';
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;
}
