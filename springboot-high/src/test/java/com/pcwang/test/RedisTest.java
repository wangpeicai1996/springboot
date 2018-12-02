package com.pcwang.test;

import com.pcwang.SpringbootHighApplication;
import com.pcwang.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * redis测试类
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootHighApplication.class)
public class RedisTest {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 放入一个字符串
     */
    @Test
    public void testSetString(){
        redisTemplate.opsForValue().set("test", "测试");
    }

    /**
     * 取出一个字符串
     */
    public  void testGetString(){
        //由于之前的RedisTemplate<String,Object>的value泛型设置的是Object，所以需要强转一下返回类型
        String value = (String) redisTemplate.opsForValue().get("test");
        System.out.println("value = " + value);
    }

    /**
     * 添加一个User对象到redis
     * @return
     */
    @Test
    public void testSetUser(){
        User user = new User(03,"张三","123",24);
        //设置序列化器，将java对象序列化之后存入redis
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.opsForValue().set("user", user);
    }

    /**
     * 从redis中取出java对象
     */
    public User testGetUser(){
        //设置序列化器,通过序列化器将对象反序列化
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        User user = (User) redisTemplate.opsForValue().get("user");
        System.out.println("user = " + user);
        return user;
    }

        /**
         * 基于json格式存储对象
         */
        @Test
        public  void testSetJsonUser(){
            User user = new User(03,"张三","123",24);
            //指定json格式序列化器
            redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
            redisTemplate.opsForValue().set("user",user);
        }


    /**
     * 基于json格式取出对象
     */
    @Test
    public  User testGetJsonUser(){
        //指定json格式序列化器
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        User user = (User)redisTemplate.opsForValue().get("user");
        System.out.println("user = " + user);
        return user;
    }
}
