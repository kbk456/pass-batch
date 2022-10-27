package com.example.pass;

import com.example.pass.job.pass.ExpirePassesJobConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@Slf4j
@SpringBootTest
@SpringBatchTest
@ActiveProfiles("test")
@ContextConfiguration(classes = {ExpirePassesJobConfig.class})
public class ExpirePassesJobConfigTest {
    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;


}
