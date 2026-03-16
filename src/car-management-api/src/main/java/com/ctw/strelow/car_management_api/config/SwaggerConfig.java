package com.ctw.strelow.car_management_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Dealership Managemente API")
                        .description("API REST para gerenciamento de uma concessionária de veículos. " +
                                "Permite o cadastro e controle de Carros, Motos, Vans, Caminhões e Clientes.")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Victor Daniel Strelow")
                                .email("victor_strelow@estudante.sesisenai.org.br"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0"))
                );
    }

}