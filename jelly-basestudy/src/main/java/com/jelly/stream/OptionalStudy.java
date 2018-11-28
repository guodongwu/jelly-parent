package com.jelly.stream;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class OptionalStudy {
    public static void main(String[] args) {
        try {
            URI uri = StreamStudy.class.getClassLoader().getResource("scanner.txt").toURI();
            String contents = new String(Files.readAllBytes(Paths.get(uri)), StandardCharsets.UTF_8);
            List<String> words= Arrays.asList(contents.split(" "));
            Optional<String> optionalValue=words.stream().filter(s->s.contains("呵呵")).findFirst();
            System.out.println(optionalValue.orElse("no word")+" contains 呵呵");
            Optional<String> optionalStr=Optional.empty();
            String result=optionalStr.orElse("N/A");
            System.out.println("result:"+result);
            result=optionalStr.orElseGet(()-> Locale.getDefault().getDisplayName());
            System.out.println("result:"+result);
            try{
                result=optionalStr.orElseThrow(IllegalStateException::new);
                System.out.println("result:"+result);
            }catch (Throwable t){
                t.printStackTrace();
            }

            optionalValue=words.parallelStream().filter(s->s.contains("嘿嘿")).findFirst();
            optionalValue.ifPresent(s-> System.out.println(s+ "contains 嘿嘿"));

            Set<String> results=new HashSet<String>();
            optionalValue.ifPresent(results::add);
            Optional<Boolean> added=optionalValue.map(results::add);
            System.out.println(added);


            System.out.println(inverse(4.0).flatMap(OptionalStudy::squareRoot));
            System.out.println(inverse(-1.0).flatMap(OptionalStudy::squareRoot));
            System.out.println(inverse(0.0).flatMap(OptionalStudy::squareRoot));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    private static Optional<Double> inverse(Double x) {
        return x==0?Optional.empty():Optional.of(1/x);
    }
    public static  Optional<Double> squareRoot(Double x){
        return x<0?Optional.empty():Optional.of(Math.sqrt(x));
    }
}
