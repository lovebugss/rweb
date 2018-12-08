package com.itrjp;

import com.itrjp.common.util.SpringUtil;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class RwebOauthApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(RwebOauthApplication.class, args);
		SpringUtil.setApplicationContext(applicationContext);
	}
}
