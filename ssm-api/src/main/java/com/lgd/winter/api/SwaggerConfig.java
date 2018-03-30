package com.lgd.winter.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 接口文档配置
 *
 * @author guochao
 * @since 1.0.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket buildDocket() {
        // ParameterBuilder tokenPar = new ParameterBuilder();
        // List<Parameter> pars = new ArrayList<Parameter>();
        // tokenPar.name("token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        // pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lgd.winter.api"))//controller路径
                .paths(PathSelectors.any())
                .build();
        // .globalOperationParameters(pars);
    }

    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .description("ssm接口文档")
                .build();
    }
}
