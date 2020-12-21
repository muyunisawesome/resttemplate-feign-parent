package com.cht.demo;

import com.cht.rst.feign.EnableChtFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableChtFeignClients //(defaultConfiguration = MyFeignConfiguration4.class)
public class DemoConsumerApp {

	public static void main(String[] args) {
		SpringApplication.run(DemoConsumerApp.class, args);
	}
}
