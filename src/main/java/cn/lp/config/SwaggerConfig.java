package cn.lp.config;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.config
 * @Author: lp
 * @CreateTime: 2023-02-22  18:12
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {
    private final OpenApiExtensionResolver openApiExtensionResolver;

    @Autowired
    public SwaggerConfig(OpenApiExtensionResolver openApiExtensionResolver) {
        this.openApiExtensionResolver = openApiExtensionResolver;
    }
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("default")
            .apiInfo(apiInfo("测试环境通用接口"))
            .pathMapping("/")
            .select()
            .apis(RequestHandlerSelectors.basePackage("cn.lp.controller"))
            .paths(PathSelectors.any())
            .build()
            .extensions(openApiExtensionResolver.buildExtensions("1.2.x"));
    }
    private ApiInfo apiInfo(String desc) {
        return new ApiInfoBuilder()
            //页面标题
            .title(desc)
            //设置做者联系方式,无关紧要
            .contact(new Contact("lp", "https://www.baidu.com", "2572595171@qq.com"))
            //版本号
            .version("1.0")
            //描述
            .description("API 描述")
            .build();

    }
}
