package com.jelly.redis.study;

import com.jelly.redis.study.config.RedisConfig;
import com.jelly.redis.study.utils.RedisUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class RedisTest {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context=new AnnotationConfigApplicationContext(RedisConfig.class);
        RedisUtils redisUtils=context.getBean(RedisUtils.class);
        System.out.println("删除键:strKey");
        redisUtils.delete("strKey");
        redisUtils.set("strKey","strValue");
        redisUtils.set("strKey10sec","strValue10sec",10, TimeUnit.SECONDS);
        String v1= redisUtils.get("strKey");
        String v2=redisUtils.get("strKey10sec");
        System.out.println("设置String值:"+v1+",设置10sec秒过期:"+v2);
        redisUtils.expire("strKey",20,TimeUnit.SECONDS);
        Date date=new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND,5);
        redisUtils.expireAt("strKey",calendar.getTime());
        redisUtils.set("strKey2","strValue2");
        redisUtils.dump("strKey2");
        boolean r=redisUtils.hasKey("strKey3");
        System.out.println(redisUtils.get("strKey2")+","+r);
        Set<String> s= redisUtils.keys("s*");
        System.out.println("匹配:"+s.size());
        boolean isMove=redisUtils.move("strKey2",1);
        //如果存在则无法移动
        System.out.println("移动?=====>"+isMove);
        redisUtils.persist("strKey");
        String key=redisUtils.randomKey();
        System.out.println("随机key:"+key);
        /*--------------------------*/
        boolean isStarted=true;
        redisUtils.set("strWhile","abcdefg",2,TimeUnit.SECONDS);
        while (isStarted){
            long ex= redisUtils.getExpire("strWhile");
            if(ex<=0){
                isStarted=false;
            }
            System.out.println("有效时间剩余:"+ex+"sec");
            Thread.sleep(1000);
        }
        redisUtils.rename("strKey2","strKey3");
        redisUtils.renameIfAbsent("strKey3","strKey4");
        DataType dataType= redisUtils.type("strKey3");
        System.out.println("strKey3类型:"+dataType.name());
        String range=redisUtils.getRange("strKey3",1,3);
        String range2=redisUtils.getRange("strKey3",5,10);
        String range3=redisUtils.getRange("strKey3",20,10);
        System.out.println("range:"+range+",range2:"+range2+",range3:"+range3);
        String getAndSet=redisUtils.getAndSet("strKey3","strValue3");
        System.out.println("获取旧值:"+getAndSet);
        boolean bit=redisUtils.getBit("strKey4",0);
        System.out.println("偏移:"+bit);
        boolean setbit=redisUtils.setBit("strKey4",1,true);
        System.out.println("setbit:"+setbit);
        bit=redisUtils.getBit("strKey4",1);
        System.out.println("偏移:"+bit);
        //strValue2 ---> sabcdlue2
        redisUtils.setRange("strKey4","abcd",1);
        redisUtils.set("keyNum","5");
        redisUtils.incrBy("keyNum",1);
        System.out.println("1:"+redisUtils.get("keyNum"));
        redisUtils.incrByFloat("keyNum",1.03);
        System.out.println("2:"+redisUtils.get("keyNum"));
        redisUtils.append("strKey4",redisUtils.get("keyNum"));
        System.out.println(redisUtils.get("strKey4")+",Key strKey size:"+redisUtils.size("strKey4"));
        Map<String,String> maps=new HashMap<>();
        maps.put("a","a");
        maps.put("b","b");
        maps.put("c","c");
        maps.put("d","d");
        maps.put("e","e");
        //存在不存在都执行
        redisUtils.multSet(maps);
        //有一个存在则不执行
        redisUtils.multSetIfAbsent(maps);
        System.out.println("==================Hash操作  Map 没有重复值=========================");
        redisUtils.hPut("key1","hash1","hashValue");
        System.out.println(redisUtils.hGet("key1","hash1"));

        Map<String,String> hash=new HashMap<>();
        hash.put("a","a");
        hash.put("b","b");
        hash.put("c","c");

        redisUtils.hPutAll("hkey",hash);
        List<Object> list=redisUtils.hValues("hkey");
        list.forEach(t-> System.out.println(t.toString()));
        //cursor 作为迭代 使用
        Cursor<Map.Entry<Object,Object>> cursor= redisUtils.hScan("hkey", ScanOptions.NONE);
        System.out.println("cursor:"+cursor.toString());
        while (cursor.hasNext()){
            Map.Entry<Object,Object> entry=cursor.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        System.out.println("=====================List操作 可以重复  可以实现队列====================");
        redisUtils.lLeftPush("lkey","111");
        redisUtils.lLeftPush("lkey","222","333");
        while (redisUtils.hasKey("lkey")) {
         String str=redisUtils.lLeftPop("lkey");
         System.out.print("获取list值:"+str+",");
        }
        List nums= Arrays.asList(new String[]{"aa","bb","cc","dd"});
        redisUtils.lLeftPushAll("skey",nums);
        while (redisUtils.hasKey("skey")) {
            redisUtils.lRightPopAndLeftPush("skey", "dkey");
        }
        System.out.println("\n===========Set操作==========================");
        redisUtils.sAdd("setKey","sa","sb","sc","sd","sa","se");
        redisUtils.sAdd("setKey1","sa","sb");
        //count是每次扫描的key个数，并不是结果集个数。
        // count要根据扫描数据量大小而定，Scan虽然无锁，但是也不能保证在超过百万数据量级别搜索效率；
        // count不能太小，网络交互会变多，count要尽可能的大。
        // 在搜索结果集1万以内，建议直接设置为与所搜集大小相同
        Cursor<String> setCursor= redisUtils.sScan("setKey",ScanOptions.scanOptions().match("s*").count(Integer.MAX_VALUE).build());
        while (setCursor.hasNext()){
            System.out.println("setValue:"+setCursor.next());
        }
        Set<String> diff= redisUtils.sDifference("setKey","setKey1");
        diff.forEach(t-> System.out.println(t.toString()));
        Set<String> sunion= redisUtils.sUnion("setKey","setKey1");
        sunion.forEach(t-> System.out.print(t.toString()+","));
        System.out.println("\n==========zSet操作=================================");
        redisUtils.zAdd("zsetKey","abc",1);
        redisUtils.zAdd("zsetKey","abcd",2);
        redisUtils.zAdd("zsetKey","abcde",2);
        long zz=redisUtils.zZCard("zsetKey");
        System.out.println(zz);
        Set<String> zss=redisUtils.zRangeByScore("zsetKey",1,7) ;
        zss.forEach(t-> System.out.println(t.toString()));
    }
}
