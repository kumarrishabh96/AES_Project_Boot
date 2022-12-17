package com.ty.aes_project_boot.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfiguration {

	@Bean
	public Docket getDocket() {
		Contact contact = new Contact("ty", "testYantra.com", "tastyantra@gmail.com");
		List<VendorExtension> extensions = new ArrayList<VendorExtension>();
		ApiInfo apiInfo = new ApiInfo("AES Project", "Boot app for Encrption Decription", "1.0", "testyantra.com",
				contact, "apache tomcat", "www.apache.com", extensions);
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ty.aes_project_boot")).build();
	}
}
