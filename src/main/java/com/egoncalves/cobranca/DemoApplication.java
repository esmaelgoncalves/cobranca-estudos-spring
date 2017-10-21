package com.egoncalves.cobranca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Configuration
	public static class MvcConfig extends WebMvcConfigurerAdapter {
		
		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addRedirectViewController("/", "/titulos");
			registry.addViewController("/login").setViewName("login");
		    registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		}
		
	}
}
