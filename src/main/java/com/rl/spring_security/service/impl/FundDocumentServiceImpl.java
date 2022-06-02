package com.rl.spring_security.service.impl;

import com.rl.spring_security.entity.FundDocument;
import com.rl.spring_security.mapper.FundDocumentMapper;
import com.rl.spring_security.service.IFundDocumentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 合同信息表 服务实现类
 * </p>
 *
 * @author RenLei
 * @since 2022-06-02
 */
@Service
public class FundDocumentServiceImpl extends ServiceImpl<FundDocumentMapper, FundDocument> implements IFundDocumentService {

}
