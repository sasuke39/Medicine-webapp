package cn.zxh.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class jedisUtils {
    private static JedisPool jp = null;
    private static  String host ;
    private static int port;
    private static int maxTotal;
    private static int maxIdle;
    static {
        ResourceBundle rb = ResourceBundle.getBundle("redis");
         host = rb.getString("redis.host");
         port = Integer.parseInt(rb.getString("redis.port"));
         maxTotal = Integer.parseInt(rb.getString("redis.maxTotal"));
         maxIdle =Integer.parseInt(rb.getString("redis.maxIdle"));

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);//设置活动连接数
        jedisPoolConfig.setMaxTotal(maxTotal);//设置总连接数

        jp = new JedisPool(jedisPoolConfig,host,port);
    }
    public static Jedis getJedis(){
        return jp.getResource();

    }
}
