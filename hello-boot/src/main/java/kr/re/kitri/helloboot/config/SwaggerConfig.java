package kr.re.kitri.helloboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	UiConfiguration uiConfig() {
		return UiConfigurationBuilder.builder()
															.deepLinking(true)
															.displayOperationId(false)
															.defaultModelsExpandDepth(1)
															.defaultModelExpandDepth(1)
															.defaultModelRendering(ModelRendering.EXAMPLE)
															.displayRequestDuration(false)
															.docExpansion(DocExpansion.NONE)
															.filter(false)
															.maxDisplayedTags(null)
															.operationsSorter(OperationsSorter.ALPHA)
															.showExtensions(false)
															.tagsSorter(TagsSorter.ALPHA)
															.supportedSubmitMethods(UiConfiguration.Constants.NO_SUBMIT_METHODS)
															.validatorUrl(null).build();
	}
	
	public ApiInfo metadata() {
		return new ApiInfoBuilder().title("Employee API Service - Swagger")
														.description("Employee API Service for Everyone")
														.version("0.1")
														.build();
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
																										.apis(RequestHandlerSelectors.any())
																										.paths(PathSelectors.regex("/employees/*.*"))
//																										.paths(PathSelectors.regex("/employees.*"))
																										.build()
																										.apiInfo(metadata());
	}
}
