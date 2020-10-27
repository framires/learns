package br.com.ramires.learn.basics.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Config Swagger
 * 
 * @author feliperamires
 * @date 26,Out 2020
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { 
	    	"classpath:/META-INF/resources/",
	    	"classpath:/resources/",
	    	"classpath:/static/",
	    	"classpath:/public/" };

    @Bean
    public Docket apiDocketV1() {
	return new Docket(DocumentationType.SWAGGER_2).select().
			apis(RequestHandlerSelectors.basePackage("br.com.ramires.learn"))
			.paths(PathSelectors.any()).build().useDefaultResponseMessages(false).apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
	return new ApiInfoBuilder()
			.title("Basic Java - Learn about SpringBoot ")
			.description("Simple project Java using SpringBoot").build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

}
