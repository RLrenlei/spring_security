package com.rl.spring_security.service.impl;

import com.rl.spring_security.entity.ContractFieldConfig;
import com.rl.spring_security.mapper.ContractFieldConfigMapper;
import com.rl.spring_security.service.IContractFieldConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 合同需要解析的字段的类型和名称 服务实现类
 * </p>
 *
 * @author RenLei
 * @since 2022-06-02
 */
@Service
public class ContractFieldConfigServiceImpl extends ServiceImpl<ContractFieldConfigMapper, ContractFieldConfig> implements IContractFieldConfigService {

}
