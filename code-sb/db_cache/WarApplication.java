package com.example.demo.db_cache;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cache.annotation.*;

@SpringBootApplication
@EnableCaching
public class WarApplication {
	/*

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-cache</artifactId>
		</dependency>

		<dependency>
			<groupId>com.hazelcast</groupId>
			<artifactId>hazelcast</artifactId>
		</dependency>

		<dependency>
			<groupId>com.hazelcast</groupId>
			<artifactId>hazelcast-spring</artifactId>
		</dependency>
	 */

	public static void main(String[] args) {
		SpringApplication.run(WarApplication.class, args);
	}

}

