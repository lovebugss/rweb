package com.itrjp;

import com.itrjp.common.util.EmailUtil;
import com.itrjp.common.util.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/*
 * 程序入口
 * @Author renjp
 * @Date 2018/12/12 11:38
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
// 开启定时任务
@EnableScheduling
@MapperScan(basePackages = "com.itrjp.backend.mapper")
public class RwebBackendApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(RwebBackendApplication.class, args);
		SpringUtil.setApplicationContext(applicationContext);
		JavaMailSender jms = SpringUtil.getBean(JavaMailSender.class);
		EmailUtil.setMailSender(jms);

	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RwebBackendApplication.class);
	}
}
