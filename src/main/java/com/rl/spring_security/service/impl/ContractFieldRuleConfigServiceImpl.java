package com.rl.spring_security.service.impl;

import com.rl.spring_security.entity.ContractFieldRuleConfig;
import com.rl.spring_security.mapper.ContractFieldRuleConfigMapper;
import com.rl.spring_security.service.IContractFieldRuleConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 合同每个字段的匹配规则 服务实现类
 * </p>
 *
 * @author RenLei
 * @since 2022-06-02
 */
@Service
public class ContractFieldRuleConfigServiceImpl extends ServiceImpl<ContractFieldRuleConfigMapper, ContractFieldRuleConfig> implements IContractFieldRuleConfigService {

}
