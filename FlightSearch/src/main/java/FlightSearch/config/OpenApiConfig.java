package FlightSearch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI().info(new Info()
				             .title("Flight-Search")
				             .description("Cruds to search flight for user and update/add/delete flight details for admin")
				             .version("v1.0")
				             .contact(new Contact()
				            		 .name("Adarsh Gour")
				            		 .email("Rudransh3067@gmail.com"))
				             .termsOfService("Terms")
				             .license(new License().name("License").url("#")));
	}
}