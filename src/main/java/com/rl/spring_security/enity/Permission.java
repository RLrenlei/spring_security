package com.rl.spring_security.enity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_permission")
public class Permission {
    private Long id;
    private String code;
    private String description;
    private String url;
}
