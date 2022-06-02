package com.rl.spring_security.entity;

import lombok.Data;

/**
 * @author Ren
 * @description TODO
 * @date 2022/6/2 14:57
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
