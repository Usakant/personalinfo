package com.personalinfo;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Personal Information API",
				version = "1.0",
				description = "API documentation for managing Personal Details"
		)
)
@SpringBootApplication

public class PersonalInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalInfoApplication.class, args);
    }

}
