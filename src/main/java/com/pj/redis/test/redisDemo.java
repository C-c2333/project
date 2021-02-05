package com.pj.redis.test;/**
 * @Author cdl
 * @Date 2021/2/4 10:37
 * @Param $
 * @Return $
 */

import com.alibaba.fastjson.JSON;
import com.pj.redis.service.IRedisService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName redisTest
 *@Description TODO
 *@Author cdl
 *@Date 2021/2/4 10:37
 **/
@AllArgsConstructor
@Component
@Slf4j
@RestController
@RequestMapping("redisDemo")
public class redisDemo {

    private IRedisService redisService;

   // @PostConstruct
    public void addRedis(){
        redisService.set("1",11111);

        log.info("hSet添加");
        ArrayList<Integer> strings = new ArrayList<>();
        strings.add(1);
        redisService.hSet("hset","hset1", strings);

        strings = new ArrayList<>();
        strings.add(2);
        redisService.hSet("hset","hset2", strings);

        Object hset = redisService.hGet("hset", "hset1");
        log.info("hGet获取key");
        System.err.println(JSON.toJSON(hset));
        hset = redisService.hGetAll("hset");
        log.info("hGetAll获取所有");
        System.err.println(JSON.toJSON(hset));

    }

    @GetMapping("delRedis")
    public void delRedis() {
       /* Boolean hset = redisService.delete("hset");
        System.err.println(hset);
        List<String> strings = new ArrayList<>();
        strings.add("hset");
        strings.add("1");
        redisService.delete(strings);*/
    }
}
