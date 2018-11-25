package com.pcwang.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis设置类
 */
@Configuration
public class MybatisConfig {

    /**
     * mybatis与springboot整合的个性化配置Bean
     * @return
     */
    public ConfigurationCustomizer getCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                //设置驼峰模式和下划线模式的映射
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
