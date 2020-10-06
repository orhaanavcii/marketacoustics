package tr.com.jforce.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ServletComponentScan(basePackages = {"tr.com.jforce.*"})
@ComponentScan(basePackages = { "tr.com.jforce.*" })
@EntityScan(basePackages = {"tr.com.jforce.*"})
@EnableJpaRepositories(basePackages = {"tr.com.jforce.*"} )
@EnableAutoConfiguration
public class UIStarter extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(UIStarter.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(UIStarter.class);
	}

}
