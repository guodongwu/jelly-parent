package com.jelly.stream;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamStudy {
    public static void main(String[] args) {
           simpleCreateStream();
           createStream();

    }

    public static <T> void show(String title, Stream<T> stream) {
        final int SIZE = 10;
        List<T> firstELements = stream.limit(SIZE + 1).collect(Collectors.toList());
        System.out.print(title + ":");
        for (int i = 0; i < firstELements.size(); i++) {
            if (i > 0) {
                System.out.print(",");
            }
            if (i < SIZE) {
                System.out.print(firstELements.get(i));
            } else {
                System.out.print("...");
            }
        }
        System.out.println();
    }

    public static void createStream() {
        URI uri = null;
        try {
            uri = StreamStudy.class.getClassLoader().getResource("scanner.txt").toURI();
            String contents = new String(Files.readAllBytes(Paths.get(uri)), StandardCharsets.UTF_8);
            Stream<String> ws = Stream.of(contents.split(" "));
            show("words", ws);
            Stream<String> song=Stream.of("gently","down","the","stream");
            show("song",song);
            Stream<String> silence=Stream.empty();
            show("silence",silence);
            Stream echos=Stream.generate(()->"Echo");
            show("echo",echos);
            Stream<Double> randoms =Stream.generate(Math::random);
            show("randoms",randoms);
            Stream<BigInteger> integers=Stream.iterate(BigInteger.ONE,n->n.add(BigInteger.ONE));
            show("integers",integers);
            Stream<String> wordsAnotherWay= Pattern.compile("\\PL+").splitAsStream(contents);
            show("wordsAnotherWay",wordsAnotherWay);
            Stream<String> lines=Files.lines(Paths.get(uri),StandardCharsets.UTF_8);
            show("lines",lines);
            Object [] powers=Stream.iterate(1.0,p->p*2)
                    .peek(e-> System.out.println("Fetching:"+e))
                    .limit(20).toArray();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void simpleCreateStream() {
        try {

            URI uri = StreamStudy.class.getClassLoader().getResource("scanner.txt").toURI();
            String contents = new String(Files.readAllBytes(Paths.get(uri)), StandardCharsets.UTF_8);
            List<String> words = Arrays.asList(contents.split("\n"));


            long count = 0;
            for (String w : words) {
                if (w.length() > 3) {
                    count++;
                }
            }
            System.out.println(count);
            count = words.stream().filter(w -> w.length() > 3).count();
            System.out.println(count);
            count = words.parallelStream().filter(w -> w.length() > 3).count();
            System.out.println(count);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}