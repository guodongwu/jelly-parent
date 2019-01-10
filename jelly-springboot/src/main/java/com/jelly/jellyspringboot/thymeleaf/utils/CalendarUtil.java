package com.jelly.jellyspringboot.thymeleaf.utils;

import java.util.Calendar;

public class CalendarUtil {
    public  static  Calendar calendarFor(
            final  int year,final  int month,final int day,final int hour,final int minute)
    {
        final Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH,day);
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minute);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        return  calendar;
    }
    private CalendarUtil(){}

}
