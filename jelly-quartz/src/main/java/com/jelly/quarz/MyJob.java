package com.jelly.quarz;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String printTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("current Time"+printTime+"random num"+new Random().nextInt(100)+jobExecutionContext.getJobDetail().getJobDataMap().get("say"));
    }
}
