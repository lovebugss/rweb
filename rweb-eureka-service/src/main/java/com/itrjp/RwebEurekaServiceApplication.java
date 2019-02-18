package com.itrjp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 程序入口
 * @author renjp
 */
@SpringBootApplication
@EnableEurekaServer
public class RwebEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RwebEurekaServiceApplication.class, args);
	}
}
