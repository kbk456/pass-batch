package com.example.pass.job.pass;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddPassesJobConfig {
    //@EnableBatchProcessing 으로 인해 Bean 으로 제공된 JobBuilderFactory, StepBuilderFactory
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final AddPassesTasklet addPassesTasklet;

    public AddPassesJobConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, AddPassesTasklet addPassesTasklet){

        this.addPassesTasklet = addPassesTasklet;
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Job addPassesJob(){
        return this.jobBuilderFactory.get("addPassesJob")
                .start(addPassesStep()).build();
    }

    @Bean
    public Step addPassesStep(){
        return this.stepBuilderFactory.get("addPassesStep")
                .tasklet(addPassesTasklet).build();
    }
}
