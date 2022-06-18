package com.rl.spring_security.mapper;

import com.rl.spring_security.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author RenLei
 * @since 2022-06-02
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}
