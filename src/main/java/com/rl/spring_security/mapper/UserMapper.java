package com.rl.spring_security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rl.spring_security.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
