//package kr.co.polycube.backendtest.batch;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import java.util.concurrent.TimeUnit;
//
//@Configuration
//@EnableBatchProcessing
//public class BatchConfiguration {
//
//    @Bean
//    public Job simpleJob(JobRepository jobRepository, Step step) {
//        return new JobBuilder("simpleJob", jobRepository).start(step).build();
//    }
//
//    @Bean
//    public Step simpleStep(JobRepository jobRepository, Tasklet simpleTasklet, PlatformTransactionManager transactionManager) {
//        return new StepBuilder("simpleStep", jobRepository).tasklet(simpleTasklet, transactionManager).build();
//    }
//
//    @Bean
//    public Tasklet simpleTasklet() {
//        return (stepContribution, chunkContext) -> {
//            for (int i = 10; i > 0; i--) {
//                TimeUnit.SECONDS.sleep(1);
//                System.out.println(i);
//            }
//            return RepeatStatus.FINISHED;
//        };
//    }
//}