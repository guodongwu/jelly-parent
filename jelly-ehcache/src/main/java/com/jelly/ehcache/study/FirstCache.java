package com.jelly.ehcache.study;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import org.junit.Test;

public class FirstCache {
    public static void main(String[] args) {
        //1创建缓存管理器
        CacheManager cacheManager=CacheManager.create(FirstCache.class.getClassLoader().getResourceAsStream("ehcache.xml"));
        //2获取缓存对象
        Cache cache=cacheManager.getCache("firstCache");
        //3创建元素
        Element element=new Element("key1","value1");
        //4将元素添加到缓存
        cache.put(element);
        //5获取缓存
        Element value=cache.get("key1");
        System.out.println("value:"+value);
        System.out.println("ObjectValue:"+value.getObjectValue());
        //删除元素
        cache.remove("key1");

        Dog dog=new Dog(1,"taidi",2);
        Element element1=new Element("taidi",dog);
        cache.put(element1);
        Element value2=cache.get("taidi");
        Dog dog2= (Dog) value2.getObjectValue();
        System.out.println("DOG:"+dog2);
        System.out.println("CacheSize:"+cache.getSize());
        //刷新缓存
        cache.flush();
        cacheManager.shutdown();

    }

    @Test
    public void run(){
        CacheManager cacheManager=CacheManager.create(FirstCache.class.getClassLoader().getResourceAsStream("ehcache.xml"));

        Cache cache=cacheManager.getCache("firstCache");
        CacheConfiguration configuration=cache.getCacheConfiguration();
        configuration.setTimeToIdleSeconds(60);
        configuration.setTimeToLiveSeconds(120);
        configuration.setMaxEntriesLocalHeap(10000);
        configuration.setMaxEntriesLocalDisk(100000);
        Element element=new Element("key2","value2");
        cache.put(element);
        System.out.println(cache.get("key2"));

    }


    public static class  Dog{
        private int id;
        private String name;
        private int age;

        @Override
        public String toString() {
            return "Dog{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public  Dog(){}
        public Dog(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
