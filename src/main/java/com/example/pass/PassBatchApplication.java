package com.example.pass;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PassBatchApplication {

    //배치잡을 실행하는 잡 빌더
    private final JobBuilderFactory jobBuilderFactory;
    //잡을 구성하는 작업 단위인 스텝 빌더
    private final StepBuilderFactory stepBuilderFactory;

    //잡 빌더와 스텝 빌더를 주입
    public PassBatchApplication(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }
    //스텝: 태스크렛으로 구성하고 스텝명을 passStep 으로 지정 한후 출력문장이 출력되는지 확인하는 코드를 작성
    @Bean
    public Step passStep(){
        return this.stepBuilderFactory.get("passStep")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("Execute PassStep");
                    return RepeatStatus.FINISHED;
                }).build();
    }
    //스텝을 실행하는 잡을 만들어서 스텝을 실행시킨다.
    @Bean
    public Job passJob(){
        return this.jobBuilderFactory.get("passJob")
                .start(passStep())
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(PassBatchApplication.class, args);
    }

}
