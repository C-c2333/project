package com.pj.redis.schedule;

import com.pj.redis.service.IRedisService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * code is far away from bug with the animal protecting
 *
 * @author lishiquan
 * @description
 * @date 2020-01-26
 */
@Component
@Slf4j
@AllArgsConstructor
public class RedisSchedule {

    private final IRedisService redisService;

    @Scheduled(fixedDelay = 120000L)
    public void keepRedisConnected() {
        redisService.get("heartBeat");
        log.info("redis连接检测: ==> {}", LocalTime.now());
    }
}
