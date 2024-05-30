
package com.example.Sql_DDL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Sql_DDLApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sql_DDLApplication.class, args);
	}
}
