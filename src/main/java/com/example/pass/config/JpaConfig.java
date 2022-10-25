package com.example.pass.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing //데이터가 저장 될때  테이블의 공통필드 예를 들면 등록시간을 자동으로 넣어주는 기능
public class JpaConfig {

}
