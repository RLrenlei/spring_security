package com.rl.spring_security.service.impl;

import com.rl.spring_security.entity.PpwClientErrorLog;
import com.rl.spring_security.mapper.PpwClientErrorLogMapper;
import com.rl.spring_security.service.IPpwClientErrorLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户端入库错误日志表 服务实现类
 * </p>
 *
 * @author RenLei
 * @since 2022-06-02
 */
@Service
public class PpwClientErrorLogServiceImpl extends ServiceImpl<PpwClientErrorLogMapper, PpwClientErrorLog> implements IPpwClientErrorLogService {

}
