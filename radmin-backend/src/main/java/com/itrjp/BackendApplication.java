package com.itrjp;

import com.itrjp.radmin.util.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@ServletComponentScan
@EnableDiscoveryClient
public class BackendApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(BackendApplication.class, args);
		SpringUtil.setApplicationContext(applicationContext);
	}
}
