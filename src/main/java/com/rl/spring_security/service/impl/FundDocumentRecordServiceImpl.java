package com.rl.spring_security.service.impl;

import com.rl.spring_security.entity.FundDocumentRecord;
import com.rl.spring_security.mapper.FundDocumentRecordMapper;
import com.rl.spring_security.service.IFundDocumentRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 合同信息记录表 服务实现类
 * </p>
 *
 * @author RenLei
 * @since 2022-06-02
 */
@Service
public class FundDocumentRecordServiceImpl extends ServiceImpl<FundDocumentRecordMapper, FundDocumentRecord> implements IFundDocumentRecordService {

}
