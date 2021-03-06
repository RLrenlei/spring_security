package com.rl.spring_security.mybatis;

import com.rl.spring_security.entity.User;
import com.rl.spring_security.mapper.UserMapper;
import com.rl.spring_security.service.IUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Ren
 * @description TODO
 * @date 2022/6/2 15:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserService service;

//    @Test
//    public void test() {
//        List<User> users = userMapper.selectList(null);
//        Assert.assertEquals(5, users.size());
//        users.forEach(System.out::println);
//    }

    @Test
    public void contextLoads() {
         User user = new User();
         user.setId(1L).setAge(999);
         int u = userMapper.updateById(user);
         System.out.println(u);
     }
}
