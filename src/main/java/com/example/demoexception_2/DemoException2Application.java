package com.example.demoexception_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisReactiveAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class DemoException2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoException2Application.class, args);
	}

}
