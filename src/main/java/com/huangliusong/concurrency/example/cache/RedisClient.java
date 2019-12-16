package com.huangliusong.concurrency.example.cache;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

/**
 * @author huangliusong
 * @since 2019/12/17
 * {@link }
 */
@Component
public class RedisClient {

    @Resource(name = "jedisPool")
    private JedisPool jedisPool;


    public void set(String key, String value) throws Exception {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    public void get(String key) throws Exception {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.get(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
