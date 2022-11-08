package com.exult;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@PropertySource(value = { "classpath:messages.properties" })
public class ExappApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ExappApplication.class, args);
		
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
			}
		};
	}
//	
//	@Configuration
//	@EnableWebMvc
//	public class WebConfig implements WebMvcConfigurer {
//
//	    @Override
//	    public void addCorsMappings(CorsRegistry registry) {
//	    	registry.addMapping("/exult/**")
//            .allowedOrigins("http://bookappoint.com")
//            .allowedMethods("GET","POST","PUT", "DELETE")
//            .maxAge(3600);
//	    }
//	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ExappApplication.class);
    }

}
