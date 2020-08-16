package com.practice.practice.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestConnection {

    //单实例连接Redis
    @Test
    public void testJedis(){
        //创建一个redis连接
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //执行redis命令
        jedis.set("context","redis测试");
        //从redis中取值
        jedis.get("context");
        //打印值
        System.out.println(jedis.get("context"));
        //释放连接
        jedis.close();
    }

    //连接池连接
    @Test
    public void testJedisForPool(){
        //创建一个连接池对象
        JedisPool jedisPool = new JedisPool("127.0.0.1",6379);
        //从连接池中获取一个连接对象
        Jedis jedis = jedisPool.getResource();
        jedis.set("title","redis连接池测试");
        String value = jedis.get("title");
        System.out.println(value);
        jedisPool.close();

    }

}
