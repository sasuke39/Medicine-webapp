package cn.zxh.test;

import cn.zxh.dao.MedicineDao;
import cn.zxh.service.ProductService;
import cn.zxh.utils.RedisClusterClient;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class redisTest {
    @Test
    public void run() {
// 1. 创建jedis对象，需要ip和port
//        Jedis jedis = new Jedis("127.0.0.1", 6379);
//
//        // 2. 使用jedis操作redis，jedis的方法和命令是一样的
//        String pong = jedis.ping();
//        System.out.println(pong);
//
//        String key = "jedis";
//        String setResult = jedis.set(key, "hello redis!");
//        System.out.println(setResult);
//
//        String getResult = jedis.get(key);
//        System.out.println(getResult);
//
//        // 3. 释放资源，关闭jedis
//        jedis.close();

        Jedis jedis = new Jedis("192.168.0.102", 6379);
//        jedis.
        System.out.println("连接成功");
        //设置 redis 字符串数据
        jedis.set("runoobkey", "www.runoob.com");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: " + jedis.get("runoobkey"));
//        jedis.zadd
    }
//
//    @Test
//    public void redisjiqun() {
//
//        ResourceBundle rb = ResourceBundle.getBundle("redis");
//        // 创建并填充节点信息
//        Set<HostAndPort> nodes = new HashSet<>();
////        nodes.add(new HostAndPort("redis.host", "redis.port"));
//        nodes.add(new HostAndPort("127.0.0.1", 7002));
//        nodes.add(new HostAndPort("127.0.0.1", 7003));
//        nodes.add(new HostAndPort("127.0.0.1", 7004));
//        nodes.add(new HostAndPort("127.0.0.1", 7005));
//        nodes.add(new HostAndPort("127.0.0.1", 7006));
//        // 创建JedisCluster对象
//        JedisCluster jedisCluster = new JedisCluster(nodes);
//        // 使用jedisCluster操作redis
//        String key = "jedisCluster";
//        String setResult = jedisCluster.set(key, "hello redis!");
//        System.out.println(setResult);
//        String getResult = jedisCluster.get(key);
//        System.out.println(getResult);
//        // 关闭jedisCluster（程序执行完后才能关闭，内部封装了连接池） 					jedisCluster.close();
//
//
//    }
    @Test
    public void redisto(){

        RedisClusterClient clusterClient =new RedisClusterClient();
        clusterClient.put("name","zxh000");
        Object name = clusterClient.get("name");
        System.out.println(name.toString());
    }

//    public static void main(String[] args) {
//
//        RedisClusterClient clusterClient;
//
//    }
}
