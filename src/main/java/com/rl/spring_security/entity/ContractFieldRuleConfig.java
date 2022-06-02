package com.rl.spring_security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 合同每个字段的匹配规则
 * </p>
 *
 * @author RenLei
 * @since 2022-06-02
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("contract_field_rule_config")
@ApiModel(value = "ContractFieldRuleConfig对象", description = "合同每个字段的匹配规则")
public class ContractFieldRuleConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键Id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("匹配前缀")
    @TableField("prefix")
    private String prefix;

    @ApiModelProperty("匹配后缀")
    @TableField("suffix")
    private String suffix;

    @ApiModelProperty("合同对应的托管机构id，1招商")
    @TableField("agency_id")
    private Integer agencyId;

    @ApiModelProperty("对应合同需要解析的字段表的id")
    @TableField("cfc_id")
    private Integer cfcId;

    @ApiModelProperty("修改者Id;第一次创建时与Creator值相同，修改时与修改人值相同")
    @TableField("creatorid")
    private Integer creatorid;

    @ApiModelProperty("创建时间,默认第一次创建的getdate()时间")
    @TableField("createtime")
    private LocalDateTime createtime;

    @ApiModelProperty("修改者Id;第一次创建时与Creator值相同，修改时与修改人值相同")
    @TableField("updaterid")
    private Integer updaterid;

    @ApiModelProperty("修改时间;第一次创建时与CreatTime值相同，修改时与修改时间相同")
    @TableField("updatetime")
    private LocalDateTime updatetime;

    @ApiModelProperty("匹配规则顺序")
    @TableField("sequence")
    private Integer sequence;


}
