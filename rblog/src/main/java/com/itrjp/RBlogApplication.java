package com.itrjp;

import com.itrjp.common.util.EmailUtil;
import com.itrjp.common.util.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication()
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableTransactionManagement
@EnableScheduling
@MapperScan(basePackages = "com.itrjp.rweb.mapper")
public class RBlogApplication extends SpringBootServletInitializer {

	@Autowired
	private JavaMailSender mailSender;
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(RBlogApplication.class, args);
		SpringUtil.setApplicationContext(applicationContext);
		JavaMailSender jms = SpringUtil.getBean(JavaMailSender.class);
		EmailUtil.setMailSender(jms);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RBlogApplication.class);
	}
}
