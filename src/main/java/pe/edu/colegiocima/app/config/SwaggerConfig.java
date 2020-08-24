package pe.edu.colegiocima.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket apiV1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("appcima-api-1.0")
                .apiInfo(getApiV1Info())
                //.produces(Set.of("application/json","application/xml"))
                .produces(Set.of("application/json"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("pe.edu.colegiocima.app"))
                .paths(PathSelectors.ant("/**"))
                .build();
    }

    private ApiInfo getApiV1Info() {
        return new ApiInfo(
                "Documentación del REST API",
                "Documentación del API REST de los recursos del backend de la plataforma CIMA",
                "1.0",
                "urn:tos",
                new Contact("Agapito Guevara","http://colegiocima.edu.pe/","jhony.agapito@colegiocima.edu.pe"),
                "Apache 2.0","http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }
}
