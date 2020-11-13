package com.guangfei.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@ConfigurationProperties(prefix="person")
@Data
public class Person {
    private String nickname;
    private String age;
    private List<String> schools;
}
