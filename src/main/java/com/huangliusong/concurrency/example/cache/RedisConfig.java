package com.huangliusong.concurrency.example.cache;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/**
 * @author huangliusong
 * @since 2019/12/16
 * {@link }
 */
@Configuration
public class RedisConfig {
    @Bean(name = "jedisPool")
    public JedisPool jedisPool(@Value("${jedis.host}") String host,
                               @Value("${jedis.port}") int port) {
        return new JedisPool(host, port);
    }
}
