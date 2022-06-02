package com.rl.spring_security.service.impl;

import com.rl.spring_security.entity.Contract;
import com.rl.spring_security.mapper.ContractMapper;
import com.rl.spring_security.service.IContractService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 合同字段详情表 服务实现类
 * </p>
 *
 * @author RenLei
 * @since 2022-06-02
 */
@Service
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contract> implements IContractService {

}
