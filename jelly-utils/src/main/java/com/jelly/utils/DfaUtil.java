package com.jelly.utils;

import cn.hutool.dfa.WordTree;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 过滤敏感词及脏词
 * @author RYX
 */
public final class DfaUtil {
    private static WordTree wordTree;
    static{
        wordTree=new WordTree();
        Set<String> keyWordSet = new HashSet<String>();
        BufferedReader reader=null;
        String temp=null;
        try{
            ClassPathResource classPathResource = new ClassPathResource("wfc.dic");
            System.out.println(classPathResource.getPath());
            InputStream inputStream =classPathResource.getInputStream();
            reader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            int line=0;
            while((temp=reader.readLine())!=null){
                keyWordSet.add(temp);
                line++;
            }
            System.out.println(line);
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            if(reader!=null){
                try{
                    reader.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        wordTree.addWords(keyWordSet);
    }
    public static String replace(String badText){
        return replace(badText,"*");
    }
    public static String replace(String badText,String replaceText){
        List<String> matchAll = wordTree.matchAll(badText, -1, false, false);
        Set<String> matches=new HashSet<>(matchAll);
        for (String match:matches){
            badText=badText.replaceAll(match,replaceText);
        }
        return badText;
    }
    public static void main(String[] args) {
       String text = "我有一代弓箭大土豆，刚弓箭出锅的弓箭";
       System.out.println(DfaUtil.replace(text));
       Set<String> sets=new HashSet<>();
       sets.add("马保国");
       sets.add("耗子尾汁");

    }



}
