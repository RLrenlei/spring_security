package com.rl.spring_security.security.detailservice;

import com.rl.spring_security.config.BrowserSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Ren
 * @description 自定义数据源来获取数据
 * @date 2021/12/30 10:32
 */
@Component
public class MyUserDetailService {

//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println("登录用户名"+username);
//        String password = passwordEncoder.encode("123456");
//        System.out.println("密码是"+password);
//        return new User(username, password,
//                // 账户是否启用，账户没有过期，身份认证是否有效，账户没有被锁定
//                true, true, true, false,
//                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
//    }
}
