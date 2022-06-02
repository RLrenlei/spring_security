package com.rl.spring_security.service.impl;

import com.rl.spring_security.entity.User;
import com.rl.spring_security.mapper.UserMapper;
import com.rl.spring_security.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author RenLei
 * @since 2022-06-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
