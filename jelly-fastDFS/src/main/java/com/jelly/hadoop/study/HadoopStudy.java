package com.jelly.hadoop.study;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class HadoopStudy {
    public static void main(String[] args) throws URISyntaxException, IOException {

        System.setProperty("HADOOP_USER_NAME", "hadoop");
        System.setProperty("hadoop.home.dir", "D:\\hadoop-3.2.1");
        String uri="hdfs://192.168.83.128:9010";
           /* Configuration conf = new Configuration();
            URI uri = new URI("hdfs://192.168.83.128:9010");
            fs = FileSystem.get(uri, conf);
            Path path=new Path("/test");
            boolean flag = fs.mkdirs(path);
            System.out.println(flag);
            if(fs.exists(path)){
               //flag=fs.delete(path,true);
                //System.out.println(flag);
                InputStream is=HadoopStudy.class.getClassLoader().getResourceAsStream("hadoop.txt");
                OutputStream os=fs.create(new Path("/test/hadoop.txt"));
                IOUtils.copyBytes(is,os,2048,true);
                System.out.println("yes");
            }
            */
            DatanodeInfo[] datanodeInfos=HdfsUtils.getHdfsNodes(uri);
            for (DatanodeInfo datanodeInfo:datanodeInfos){
                System.out.println(datanodeInfo.getHostName()+"==>"+datanodeInfo.getHostName());
            }
            String[]files=HdfsUtils.listFile(uri,"/test",null);
            for (int i=0;i<files.length;i++){
                System.out.println(files[i]);
            }
            String path = System.getProperty("user.dir");
            path=path+"/jelly-fastDFS/src/main/java/com/jelly/hadoop/study/hadoop.txt";
            //请求服务器一定要设置环境变量
            //https://github.com/steveloughran/winutils
           // 将下载好的WINUTILS.EXE复制到bin目录下，将	HADOOP.DLL复制到System32目录下
            System.out.println(path);
            HdfsUtils.getFile(uri,"/test/hadoop.txt",path);

    }
}
