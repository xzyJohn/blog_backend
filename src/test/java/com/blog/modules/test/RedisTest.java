package com.blog.modules.test;

import com.blog.core.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author xzy
 * @date Created in 16:43 2020/6/10
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {
    @Resource
    private RedisUtils redisUtils;

    @Test
    public void testCreate(){
        redisUtils.set("test_key_1","test_value_1");
        System.out.println("create!!!");
    }

    @Test
    public void testGet(){
        System.out.println(redisUtils.get("test_key_1"));
        System.out.println("get!!!");
    }

    @Test
    public void testDelete(){
        redisUtils.del("test_key_1");
        System.out.println("delete!!!");
    }
}
