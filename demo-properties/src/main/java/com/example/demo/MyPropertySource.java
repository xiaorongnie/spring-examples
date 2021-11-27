package com.example.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource(value = {"classpath:jdbc.properties"})
@ConfigurationProperties(prefix = "jdbc")
public class MyPropertySource {
    private String account;
    private String pwd;

    public void connectDb() {
        System.out.println("Database has connected, jdbc account is "
                + account + ", password is " + pwd);
    }
}
