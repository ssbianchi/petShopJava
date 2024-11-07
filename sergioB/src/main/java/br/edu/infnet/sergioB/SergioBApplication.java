package br.edu.infnet.sergioB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SergioBApplication {

	public static void main(String[] args) {
		SpringApplication.run(SergioBApplication.class, args);
	}

}
