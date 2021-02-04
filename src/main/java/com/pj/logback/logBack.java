package com.pj.logback;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 *@ClassName logBack
 *@Description TODO
 *@Author cdl
 *@Date 2021/2/4 15:13
 **/
@AllArgsConstructor
@Component
@Slf4j
public class logBack {
    @PostConstruct
    public void pringLog(){
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
    }
}
