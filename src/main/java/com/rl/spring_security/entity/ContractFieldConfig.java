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
 * 合同需要解析的字段的类型和名称
 * </p>
 *
 * @author RenLei
 * @since 2022-06-02
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("contract_field_config")
@ApiModel(value = "ContractFieldConfig对象", description = "合同需要解析的字段的类型和名称")
public class ContractFieldConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键Id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("字段名称")
    @TableField("field_name")
    private String fieldName;

    @ApiModelProperty("字段中文名称")
    @TableField("field_name_cn")
    private String fieldNameCn;

    @ApiModelProperty("字段类型")
    @TableField("field_type")
    private String fieldType;

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


}
