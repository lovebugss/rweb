package com.itrjp;

import com.itrjp.radmin.util.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@ServletComponentScan
@EnableDiscoveryClient
@MapperScan("com.itrjp.radmin.dao")
public class BackendApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(BackendApplication.class, args);
		SpringUtil.setApplicationContext(applicationContext);
	}
}
