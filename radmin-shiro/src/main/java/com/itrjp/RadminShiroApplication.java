package com.itrjp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
@MapperScan(basePackages = "com.itrjp.shiro.mapper")
public class RadminShiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(RadminShiroApplication.class, args);
	}
}
