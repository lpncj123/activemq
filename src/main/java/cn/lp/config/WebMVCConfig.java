package cn.lp.config;

import cn.lp.handler.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.config
 * @Author: lp
 * @CreateTime: 2023-02-23  10:55
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
@Primary
public class WebMVCConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor())
            .addPathPatterns("/userController/test/verify1");
    }

}
