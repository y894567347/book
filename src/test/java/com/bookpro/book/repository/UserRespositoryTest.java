package com.bookpro.book.repository;

import com.bookpro.book.dataobject.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/16 22:09
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRespositoryTest {

    @Autowired
    UserRespository userRespository;

    @Test
    public void test(){

        User user = userRespository.findByusername("root");
        Assert.assertNotNull(user);
    }
}