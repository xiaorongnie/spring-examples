package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Properties;


@Configuration
@ConfigurationProperties
public class AppPropertiesValue {
    /**
     * 采用value
     */
    @Value("${test.msg}")
    private String msg;

    @Autowired
    private Environment env;

    @Autowired
    private MyConfigurationProperties myProperties;

    @Autowired
    private MyPropertySource myPropertySource;

    @PostConstruct
    public void test() throws IOException {
        // @Value注解读取指定属性
        System.out.println("@Value -> " + msg);
        // Environment
        System.out.println("Environment -> " + env.getProperty("test.msg"));
        // PropertiesLoaderUtils读取
        Properties properties = PropertiesLoaderUtils.loadProperties(new EncodedResource(new ClassPathResource("application.properties")));
        System.out.println("PropertiesLoaderUtils -> " + properties.getProperty("test.msg"));
        // ConfigurationProperties
        System.out.println("ConfigurationProperties -> " + myProperties.getMsg());
        // MyPropertySource
        System.out.println("myPropertySource -> ");
        myPropertySource.connectDb();

    }
}
