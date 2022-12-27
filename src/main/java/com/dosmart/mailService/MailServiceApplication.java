package com.dosmart.mailService;

import com.dosmart.mailService.services.GenerateResetPassCode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@SpringBootApplication
public class MailServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MailServiceApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	@Bean
	public GenerateResetPassCode getGeneratePassCode(){
		return new GenerateResetPassCode() {
			@Override
			public String generateCode() {
				Random random = new Random();
				int max = 999999;
				int min = 111111;
				return String.valueOf(random.nextInt(max - min) + min);
			}
		};
	}
}
