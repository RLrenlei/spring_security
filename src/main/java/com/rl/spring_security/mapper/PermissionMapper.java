package com.rl.spring_security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rl.spring_security.enity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission> {
    List<String> selectPermissionByUser(@Param("userId") Long id);
}
