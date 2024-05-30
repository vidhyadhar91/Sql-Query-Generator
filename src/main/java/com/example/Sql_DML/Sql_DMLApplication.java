
package com.example.Sql_DML;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Sql_DMLApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sql_DMLApplication.class, args);
	}
}
