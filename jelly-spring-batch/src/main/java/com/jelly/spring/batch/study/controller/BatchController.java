package com.jelly.spring.batch.study.controller;

import cn.hutool.Hutool;
import cn.hutool.core.io.FileUtil;
import com.jelly.spring.batch.study.processor.SimpleBatchItemProcessor;
import com.jelly.spring.batch.study.processor.SimpleItemProcessor;
import com.jelly.spring.batch.study.reader.SimpleBatchLineMapper;
import com.jelly.spring.batch.study.reader.SimpleLineMapper;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.support.ResourceTransactionManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BatchController {
    @Resource
    private JobRepository jobRepository;

    @Resource
    private JobLauncher jobLauncher;
    @Resource
    private ResourcelessTransactionManager transactionManager;
    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "hello";
    }
    @RequestMapping("/file")
    public String file(){
        return "file";
    }
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws IOException, JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        InputStreamResource isr=new InputStreamResource(file.getInputStream());

        //创建reader
        FlatFileItemReader<String> flatFileItemReader=new FlatFileItemReader<String>();
        flatFileItemReader.setResource(isr);
        flatFileItemReader.setLineMapper(new SimpleBatchLineMapper());

        SimpleBatchItemProcessor processor=new SimpleBatchItemProcessor();
        StepBuilderFactory stepBuilderFactory=new StepBuilderFactory(jobRepository,transactionManager);
        Step step=stepBuilderFactory.get("step")
                .<String,String>chunk(1)
                .reader(flatFileItemReader)
                .processor(processor)
                .build();
        JobBuilderFactory jobBuilderFactory=new JobBuilderFactory(jobRepository);
        Job job=jobBuilderFactory.get("job")
                .start(step).build();

        jobLauncher.run(job,new JobParameters());

        return null;
    }
}
