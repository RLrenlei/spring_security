package com.rl.spring_security.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 合同字段详情表
 * </p>
 *
 * @author RenLei
 * @since 2022-06-02
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("contract")
@ApiModel(value = "Contract对象", description = "合同字段详情表")
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("基金id")
    @TableField("fund_id")
    private String fundId;

    @ApiModelProperty("基金名称")
    @TableField("fund_name")
    private String fundName;

    @ApiModelProperty("基金管理人")
    @TableField("trust_id")
    private String trustId;

    @ApiModelProperty("投资顾问")
    @TableField("advisor_id")
    private String advisorId;

    @ApiModelProperty("托管机构")
    @TableField("custodian_id")
    private String custodianId;

    @ApiModelProperty("外包机构")
    @TableField("liquidation_agency_id")
    private String liquidationAgencyId;

    @ApiModelProperty("综合服务商")
    @TableField("general_service_id")
    private String generalServiceId;

    @ApiModelProperty("证券经纪机构")
    @TableField("broker_id")
    private String brokerId;

    @ApiModelProperty("期货经纪机构")
    @TableField("broker_future_id")
    private String brokerFutureId;

    @ApiModelProperty("封闭期")
    @TableField("lockup_period")
    private Integer lockupPeriod;

    @ApiModelProperty("存续期")
    @TableField("duration")
    private Integer duration;

    @ApiModelProperty("锁定期")
    @TableField("lock_period")
    private Integer lockPeriod;

    @ApiModelProperty("开放日")
    @TableField("open_day")
    private String openDay;

    @ApiModelProperty("赎回日")
    @TableField("redemption_day")
    private String redemptionDay;

    @ApiModelProperty("基金经理名称")
    @TableField("fund_manager_id")
    private String fundManagerId;

    @ApiModelProperty("基金经理简介")
    @TableField("profile")
    private String profile;

    @ApiModelProperty("申购费率")
    @TableField("apply_fee")
    private BigDecimal applyFee;

    @ApiModelProperty("申购费率说明")
    @TableField("apply_fee_note")
    private String applyFeeNote;

    @ApiModelProperty("赎回费率")
    @TableField("redemption_fee")
    private BigDecimal redemptionFee;

    @ApiModelProperty("赎回费率说明")
    @TableField("redemption_fee_note")
    private String redemptionFeeNote;

    @ApiModelProperty("认购费率")
    @TableField("subscription_fee")
    private BigDecimal subscriptionFee;

    @ApiModelProperty("认购费率说明")
    @TableField("subscription_fee_note")
    private String subscriptionFeeNote;

    @ApiModelProperty("业绩报酬")
    @TableField("performance_fee")
    private BigDecimal performanceFee;

    @ApiModelProperty("业绩报酬说明")
    @TableField("performance_fee_note")
    private String performanceFeeNote;

    @ApiModelProperty("业绩报酬计提方式")
    @TableField("accrued_method")
    private String accruedMethod;

    @ApiModelProperty("业绩报酬计提对象")
    @TableField("accrued_way")
    private Integer accruedWay;

    @ApiModelProperty("业绩报酬计提日类型")
    @TableField("accrued_day_type")
    private String accruedDayType;

    @ApiModelProperty("业绩报酬计提频率")
    @TableField("accrued_frequency")
    private String accruedFrequency;

    @ApiModelProperty("管理人管理费率")
    @TableField("managementfee_trust")
    private BigDecimal managementfeeTrust;

    @ApiModelProperty("管理人管理费率说明")
    @TableField("management_fee_note")
    private String managementFeeNote;

    @ApiModelProperty("警戒线")
    @TableField("guard_line")
    private BigDecimal guardLine;

    @ApiModelProperty("止损线")
    @TableField("stop_loss_line")
    private BigDecimal stopLossLine;

    @ApiModelProperty("运营外包费率")
    @TableField("outsourcing_fee")
    private BigDecimal outsourcingFee;

    @ApiModelProperty("运营外包费率说明")
    @TableField("outsourcing_fee_note")
    private String outsourcingFeeNote;

    @ApiModelProperty("托管费率")
    @TableField("managementfee_bank")
    private BigDecimal managementfeeBank;

    @ApiModelProperty("投资策略")
    @TableField("fund_strategy_description")
    private String fundStrategyDescription;

    @ApiModelProperty("投资范围")
    @TableField("investment_scope")
    private String investmentScope;

    @ApiModelProperty("投资限制")
    @TableField("investment_restriction")
    private String investmentRestriction;

    @ApiModelProperty("风险等级")
    @TableField("risk_level")
    private Integer riskLevel;

    @ApiModelProperty("最低认购额")
    @TableField("min_investment_share")
    private BigDecimal minInvestmentShare;

    @ApiModelProperty("最低追加额")
    @TableField("subsequent_investment_share")
    private BigDecimal subsequentInvestmentShare;

    @ApiModelProperty("分红方式")
    @TableField("distribute_method")
    private Integer distributeMethod;

    @ApiModelProperty("是否支持修改分红方式")
    @TableField("distribute_modify")
    private Integer distributeModify;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("文件路径")
    @TableField("doc_url")
    private String docUrl;


}
