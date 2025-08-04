package br.com.rflwgnr.rest_api_spring_boot;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Startup {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Startup.class, args);
	}

}
