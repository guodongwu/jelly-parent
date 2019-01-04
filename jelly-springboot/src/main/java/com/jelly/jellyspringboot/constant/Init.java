package com.jelly.jellyspringboot.constant;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Init {
    public  static CopyOnWriteArrayList list;
    public  static ConcurrentHashMap<String,Object> map;

    static {
        list=new CopyOnWriteArrayList();
        map=new ConcurrentHashMap<>();
    }
}
