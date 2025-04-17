package br.com.jlgregorio.bookstore.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi(){

        return new OpenAPI()
                .info(new Info()
                        .title("Bookstore API ")
                        .version("1.0")
                        .description("Documentação para a aplicação Bookstore")
                        .termsOfService("https://www.jlgregorio.com.br")
                        .license(
                                new License()
                                        .name("Apache License 2.0")
                                        .url("https://www.apache.org/licenses/LICENSE-2.0")
                        )
                );
    }
}
