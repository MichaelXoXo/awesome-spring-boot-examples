package com.michael.springbootmybatis.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author Michael
 * @create 2019-07-13 19:00
 */
//通过@Configuration注解，让Spring来加载该类配置
@Configuration
//通过@EnableSwagger2注解来启用Swagger2
@EnableSwagger2
//@ConditionalOnExpression 为Spring的注解，用户是否实例化本类，用于是否启用Swagger的判断（生产环境需要屏蔽Swagger）
@ConditionalOnExpression("${swagger.enable:true}")
@Profile({"dev"})
public class SwaggerConfig {

    // select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，本例采用指定扫描的包路径来定义，
    // Swagger会扫描该包下所有Controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）
    @Bean
    public Docket createRestApi() {
        // apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("标题: Spring Boot 项目集成 Swagger 示例文档")
                .description("描述: 我的博客地址是 https://michael728.github.io")
                .termsOfServiceUrl("https://michael728.github.io/")
                .contact(new Contact("Michael 翔", "https://michael728.github.io", "649168982@qq.com"))
                .version("1.0.0")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();

        // 添加了一个全局参数 token
//        ParameterBuilder tokenPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<Parameter>();
//        tokenPar.name("token").description("令牌")
//                .modelRef(new ModelRef("string")).parameterType("query").required(false).build();
//        pars.add(tokenPar.build());

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                // select()函数返回一个ApiSelectorBuilder实例
                .select()
                // 决定了暴露哪些接口给 Swagger，也可以 .paths(PathSelectors.any())
                .paths(regex("/api/.*"))
                //.apis(RequestHandlerSelectors.basePackage("com.michael.springbootswagger.controller"))
                .build()
                .useDefaultResponseMessages(false);
//                .globalOperationParameters(pars);
        return docket;
    }
}
