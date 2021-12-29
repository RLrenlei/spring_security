package com.rl.spring_security.service;

import com.rl.spring_security.enity.UserAdmin;

public interface IUserService {
    UserAdmin selectUserByUsername(String username);
}
