package com.untils.framework;

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
 * Created by hefule on 2016/8/5.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)  //设置解析引擎版本
                .apiInfo(apiInfo())  //展示信息
                .select()//选择项
                .apis(RequestHandlerSelectors.basePackage("com.controller.openServer")) //请求接口
                .paths(PathSelectors.any())  //路径选择
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")  //大标题
                .description("更多更新关注lele")//小标题
                .termsOfServiceUrl("www.baidu.com")//内容地址
                .contact("何富乐") //作者
                .version("1.0") //版本
                .build();
    }
}
