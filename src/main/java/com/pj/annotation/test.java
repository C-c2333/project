package com.pj.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 *@ClassName test
 *@Description 常用注解
 *@Author cdl
 *@Date 2021/2/7 11:09
 **/
@Component
public class test {
    @Value("${url}")
    String url;

    @PostConstruct
    public void printTets() {
        System.err.println("---"+url);
    }
}
