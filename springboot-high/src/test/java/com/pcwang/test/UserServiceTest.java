package com.pcwang.test;

import com.pcwang.SpringbootHighApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * springboot测试类
 * SpringJUnit4ClassRunner.class:让junit与spring的环境整合的类
 * @SpringBootTest(classes = {SpringbootHighApplication.class})：
 *      1.表示当前类为springboot的测试类
 *      2.加载springboot启动类，启动springboot项目
 *    与junit与spring整合时用的含义相同
 * @ContextConfiguration(classpath:applicationContext.xml)
 */
@RunWith(SpringJUnit4ClassRunner.class)//启动器
@SpringBootTest(classes = {SpringbootHighApplication.class})//启动类
public class UserServiceTest {


    //书写测试方法即可
}
