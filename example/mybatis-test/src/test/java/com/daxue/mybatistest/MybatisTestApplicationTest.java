package com.daxue.mybatistest;

import com.daxue.mybatistest.mapper.UserMapper;
import com.daxue.mybatistest.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author daxue0929
 * @date 2023/7/24
 */

@SpringBootTest
public class MybatisTestApplicationTest {

    @Autowired
    public UserMapper mapper;


    @Test
    public void selectUserByIdTest() {
        User user = mapper.selectById(1);
        System.out.println(user);
    }
}