package com.rl.spring_security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 合同信息记录表
 * </p>
 *
 * @author RenLei
 * @since 2022-06-02
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("fund_document_record")
@ApiModel(value = "FundDocumentRecord对象", description = "合同信息记录表")
public class FundDocumentRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("基金id")
    @TableField("fund_id")
    private String fundId;

    @ApiModelProperty("合同名称")
    @TableField("doc_name")
    private String docName;

    @ApiModelProperty("匹配字段数量")
    @TableField("field_num")
    private Integer fieldNum;


}
