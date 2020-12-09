package com.wk.bora.doar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.wk.bora.doar.controller"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Bora Doar")
				.description("O bora doar veio com incentivo de ajudar as pessoas, "
						+ "a ultilizarem o sistema e procurar uma simples informação ou calcular seu peso, "
						+ "por meio de campos super intuitivos, com respostas na hora e bem acessíveis,"
						+ " obrigado por ultilizar o nosso sistema e a documentação estará disponivel no GitHUb.")
				.version("1.0")
				.contact(contact())
				.build();
	}
	
	private Contact contact() {
		return new Contact("Josimar Pereira",
				"https://github.com/Josimar722",
				"josimarpsantos14@hotmail.com");
	}
}

	

