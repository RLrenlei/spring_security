package com.rl.spring_security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rl.spring_security.enity.UserAdmin;
import com.rl.spring_security.mapper.UserMapper;
import com.rl.spring_security.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserAdmin> implements IUserService {
    @Override
    public UserAdmin selectUserByUsername(String username) {
        QueryWrapper<UserAdmin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        List<UserAdmin> list = this.baseMapper.selectList(queryWrapper);
        if(list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }
}
