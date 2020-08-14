package com.yglong.sbms.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yglong.sbms.**.dao")
public class SbmsAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbmsAdminApplication.class, args);
	}

}
