package com.rl.spring_security.enity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class UserAdmin {
    private Long id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
}
