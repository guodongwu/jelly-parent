package com.jelly.spring.batch.study;

import com.jelly.spring.batch.study.reader.SimpleLineMapper;
import com.jelly.spring.batch.study.processor.SimpleItemProcessor;
import com.jelly.spring.batch.study.writer.SimpleLineAggregator;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

public class BatchTest {

    public static void main(String[] args) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        String config="applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);
        JobLauncher jobLauncher=applicationContext.getBean(JobLauncher.class);
        JobRepository jobRepository=applicationContext.getBean(JobRepository.class);
        PlatformTransactionManager transactionManager=applicationContext.getBean(PlatformTransactionManager.class);

        //创建reader
        FlatFileItemReader<String> flatFileItemReader=new FlatFileItemReader<String>();
        flatFileItemReader.setResource(new FileSystemResource("jelly-spring-batch/src/main/resources/batch.txt"));
        flatFileItemReader.setLineMapper(new SimpleLineMapper());


        //创建processor
        SimpleItemProcessor processor=new SimpleItemProcessor();
      /*  //创建writer
        FlatFileItemWriter<String> flatFileItemWriter=new FlatFileItemWriter<String>();
        flatFileItemWriter.setResource(new FileSystemResource("jelly-spring-batch/src/main/resources/batch1.txt"));
        flatFileItemWriter.setLineAggregator(new SimpleLineAggregator());*/

        //创建step
        StepBuilderFactory stepBuilderFactory=new StepBuilderFactory(jobRepository,transactionManager);
        Step step=stepBuilderFactory.get("step")
                .<String,String>chunk(1)
                .reader(flatFileItemReader)
                .processor(processor)
                //.writer(flatFileItemWriter)
                .build();
        JobBuilderFactory jobBuilderFactory=new JobBuilderFactory(jobRepository);
        Job job=jobBuilderFactory.get("job")
                .start(step).build();
        jobLauncher.run(job,new JobParameters());
    }
}
