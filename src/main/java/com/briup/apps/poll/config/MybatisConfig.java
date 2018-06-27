 package com.briup.apps.poll.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.briup.apps.poll2.dao")
public class MybatisConfig {

}
