package com.bruce.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {
    private static JedisPool jedisPool;

    static {
        // 配置Jedis连接池
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(128); // 最大连接数
        config.setMaxIdle(16); // 最大空闲连接数
        config.setMinIdle(8); // 最小空闲连接数
        config.setTestOnBorrow(true); // 检查连接可用性

        // 创建连接池，假设Redis运行在本地的默认端口
        jedisPool = new JedisPool(config, "localhost", 6379);
    }

    /**
     * 获取 Jedis 连接实例
     *
     * @return Jedis 实例
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * 关闭 Jedis 连接
     *
     * @param jedis 要关闭的 Jedis 实例
     */
    public static void closeJedis(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    /**
     * 关闭连接池
     */
    public static void shutdown() {
        if (jedisPool != null) {
            jedisPool.close();
        }
    }
}
