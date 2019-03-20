package com.jelly.mybatis.mysql.util;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassUtil {
    private  ClassUtil(){}
    private static ClassUtil instance;
    static  final  ReentrantLock lock=new ReentrantLock();
    public  static  ClassUtil getInstance(){
        if(instance==null){
            lock.lock();
            instance=new ClassUtil();
            lock.unlock();
        }
        return  instance;
    }
    public Set<Class<?>> getClasses(String packageName){
        Set<Class<?>> classes =new HashSet<Class<?>>();
        boolean recursive=true;
        String packageDirName=packageName.replace(".","/");
        System.out.println(packageDirName);
        Enumeration<URL> dirs;
        try{
            dirs=Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            System.out.println(dirs.hasMoreElements());
            while (dirs.hasMoreElements()){
                URL url=dirs.nextElement();
                String protocol=url.getProtocol();
                if("file".equals(protocol)){
                    String filePath= URLDecoder.decode(url.getFile(),"UTF-8");
                    //添加到集合中
                    findAndAddClassesInPackageByFile(packageName,filePath,recursive,classes);
                }else if("jar".equals(protocol)){
                    JarFile jarFile;
                    jarFile=((JarURLConnection)url.openConnection()).getJarFile();
                    Enumeration<JarEntry> entries=jarFile.entries();
                    while (entries.hasMoreElements()){
                        JarEntry entry=entries.nextElement();
                        String name=entry.getName();
                        if(name.charAt(0)=='/'){
                            name=name.substring(1);
                        }
                        if(name.startsWith(packageDirName)){
                            int idx=name.lastIndexOf('/');
                            if(idx!=-1){
                                packageName=name.substring(0,idx).replace('/','.');
                            }
                            if (idx!=-1 || recursive){
                                if(name.endsWith(".class")&& !entry.isDirectory()){
                                    String className=name.substring(packageName.length()+1,name.length()-6);
                                    classes.add(Class.forName(packageName+"."+className));
                                }
                            }
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  classes;
    }

    public  void addClass(Set<Class<?>> classes,String filePath,String packageName){
        File[] files=new File(filePath).listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return  (file.isFile() && file.getName().endsWith(".class"))  || file.isDirectory();
            }
        });
        for (File file:files){
            String fileName=file.getName();
            if(file.isFile()){
                String className=fileName.substring(0,fileName.lastIndexOf('.'));
                if(StringUtils.isNotBlank(packageName)){
                   className=packageName+"."+className;
                }
                doAddClasses(classes,className);
            }
        }
    }

    private void doAddClasses(Set<Class<?>> classes, final String className) {
        ClassLoader classLoader=new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        };
        try {
            classes.add(classLoader.loadClass(className));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void findAndAddClassesInPackageByFile(String packageName,String packagePath,final boolean recursive,Set<Class<?>> classes){
        File dir=new File(packagePath);
        if(!dir.exists() ||!dir.isDirectory()){
            return;
        }
        File[] dirfiles=dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return (recursive && pathname.isDirectory()) || pathname.getName().endsWith(".class");
            }
        });
        for (File file:dirfiles){
            if(file.isDirectory()){
                findAndAddClassesInPackageByFile(packageName+"."+file.getName(),file.getAbsolutePath(),recursive,classes);
            }else{
                String className=file.getName().substring(0,file.getName().length()-6);
                try {
                    classes.add(Thread.currentThread().getContextClassLoader().loadClass(packageName+"."+className));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        /*Article article=new Article();
        Set<Class<?>> clsList=ClassUtil.getInstance().getClasses("com.jelly.ssm.entity");
        if(clsList!=null && clsList.size()>0){
            for (Class<?> cls:clsList){
                System.out.println(cls.getName());
                Field[] fields= cls.getDeclaredFields();
                System.out.println(fields.length);
                for (Field field:fields){
                    System.out.println(field.getName()+":"+field.getType());
                }
            }
        }*/
    }
}
