package com.jelly.reflection;

import org.junit.Test;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Date;

public class TestBean extends BaseBean {
    private   Integer id;
    private  String name;
    private Date addTime;
    private  Boolean iTer;


    public String ex;

    public Boolean getiTer() {
        return iTer;
    }

    public void setiTer(Boolean iTer) {
        this.iTer = iTer;
    }

    static {
        System.out.println("static init");
    }
    public  TestBean(){
        System.out.println("init");
    }


    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addTime=" + addTime +
                ", iTer=" + iTer +
                ", ex='" + ex + '\'' +
                '}';
    }

    @Test
    public  void Test() throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        TestBean testBean=new TestBean();
        testBean.setId(1);
        testBean.setName("a");
        testBean.setAddTime(new Date());
        testBean.setiTer(true);
        testBean.setEx("a");
        Class c=testBean.getClass();
        Field[] fields=c.getDeclaredFields();
        for (Field field:fields){
            PropertyDescriptor descriptor=new PropertyDescriptor(field.getName(),c);
            Method method=descriptor.getReadMethod();
            // 不可以为  静态方法 否则报错
            Object value=method.invoke(testBean,null);

            System.out.println(field.getName()+":"+value);
            System.out.println("全部字段:"+field.getName()+":"+field.getType());
        }
    }

    public static class TestBeanApp{
        public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, InterruptedException, IntrospectionException, InvocationTargetException {
            //1 getClass()
            //2 .class  不会初始化静态块
            //3.Class.forName() 会初始化静态块
            // Class c1=new TestBean().getClass();
            // Class c=TestBean.class;
          // Class c=Class.forName("com.jelly.reflection.TestBean");
           TestBean testBean=new TestBean( );
            testBean.setId(1);
            testBean.setName("a");
            testBean.setAddTime(new Date());
            testBean.setiTer(true);
            testBean.setEx("a");
           Class c=testBean.getClass();
           Object o= c.newInstance();
            Field[] fields=c.getDeclaredFields();
           for (Field field:fields){
               PropertyDescriptor descriptor=new PropertyDescriptor(field.getName(),c);
               Method method=descriptor.getReadMethod();
               // 不可以为  静态方法 否则报错
               // Object value=method.invoke(c);
               Object value=method.invoke(o);
               System.out.println(field.getName()+":"+value);
               System.out.println("全部字段:"+field.getName()+":"+field.getType());
           }
           Field[] fields1=c.getFields();
           for (Field field:fields1){
               System.out.println("public 字段:"+field.getName()+":"+field.getType());
           }
            Method [] methods=c.getMethods();
           for (Method method:methods){
               System.out.println("方法:"+method.getName()+":"+method.getParameterCount());
               Parameter[] parameters=method.getParameters();
               for (Parameter parameter:parameters){
                   System.out.println("参数:"+parameter.getName()+":"+parameter.getType());
               }
           }
           Field ex=c.getDeclaredField("ex");
           Field name=c.getDeclaredField("name");
           System.out.println(ex.getName());
          /* BaseBean baseBean=new TestBean();
           if(baseBean instanceof  TestBean){
               System.out.println("yes");
           }else {
               System.out.println("no");
           }*/
        }
    }
}
