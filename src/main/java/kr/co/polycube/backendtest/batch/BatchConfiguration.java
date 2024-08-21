//package kr.co.polycube.backendtest.batch;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class BatchConfiguration {
//
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public Job simpleJob() {
//        return jobBuilderFactory.get("simpleJob").start(simpleStep()).build();
//    }
//
//    @Bean
//    public Step simpleStep() {
//        return stepBuilderFactory.get("simpleStep").tasklet(())
//    }
//}