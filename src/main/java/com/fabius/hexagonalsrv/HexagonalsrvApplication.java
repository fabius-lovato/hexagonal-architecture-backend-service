package com.fabius.hexagonalsrv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HexagonalsrvApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexagonalsrvApplication.class, args);
	}

}
