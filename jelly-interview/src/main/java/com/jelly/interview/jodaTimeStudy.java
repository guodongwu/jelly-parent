package com.jelly.interview;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

public class jodaTimeStudy {
    public static void main(String[] args) {
        DateTime dateTime=new DateTime(2018,11,19,12,00,00);
        String str=dateTime.toString();
        System.out.println(str);
        str=dateTime.toString("yyyy-MM-dd HH:mm:ss");
        System.out.println(str);
        DateTime now=new DateTime(new Date());
        DateTimeFormatter formatter= DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(now.toString(formatter));
        DateTime dt2=dateTime.plusDays(1).plusYears(2).plusMonths(1).plusWeeks(1);
        System.out.println(dt2.toString("yyyy-MM-dd HH:mm:ss"));

    }
}
