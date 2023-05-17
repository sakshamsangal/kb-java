package com.example.swagger;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.enums.*;
import io.swagger.v3.oas.annotations.info.*;
import io.swagger.v3.oas.annotations.security.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Employees API", version = "2.0", description = "Employees Information"))
@SecurityScheme(name = "javainuseapi", scheme = "basic", type = SecuritySchemeType.APIKEY, in = SecuritySchemeIn.HEADER)
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

