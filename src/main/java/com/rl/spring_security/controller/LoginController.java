package com.rl.spring_security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author renlei
 * @date 2021/12/20 22:21
 * @description: 验证用户登录
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/login-success",produces = {"text/plain;charset=UTF-8"})
    public String loginSuccess() {
        return getUserName() + "登录成功";
    }

    /**
     * @author renlei
     * @date 2021/12/20 22:25
     * @description 测试资源一
     * @Param:
     * @Return:
     */
    @GetMapping(value = "/r/r1",produces = {"text/plain;charset=UTF-8"})
    public String r1() {
        return "访问资源1";
    }

    /**
     * @author renlei
     * @date 2021/12/20 22:25
     * @description 测试资源二
     * @Param:
     * @Return:
     */
    @GetMapping(value = "/r/r2",produces = {"text/plain;charset=UTF-8"})
    public String r2() {
        return "访问资源2";
    }

    private String getUserName() {
        String username;
        // 当前通过用户身份
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 用户身份
        Object principal = authentication.getPrincipal();
        if(principal == null) {
            username = "匿名";
        }
        if(principal instanceof org.springframework.security.core.userdetails.UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }

        return username;
    }
}
