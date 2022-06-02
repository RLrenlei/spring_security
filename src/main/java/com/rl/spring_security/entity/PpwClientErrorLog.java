package com.rl.spring_security.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
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
 * 客户端入库错误日志表
 * </p>
 *
 * @author RenLei
 * @since 2022-06-02
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("ppw_client_error_log")
@ApiModel(value = "PpwClientErrorLog对象", description = "客户端入库错误日志表")
public class PpwClientErrorLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，唯一标识")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("表名")
    @TableField("table_name")
    private String tableName;

    @ApiModelProperty("记录发生错误时的数据id集合，便于后续补数")
    @TableField("id_set")
    private String idSet;

    @ApiModelProperty("记录错误信息，便于排查问题")
    @TableField("error_info")
    private String errorInfo;

    @ApiModelProperty("导入日期")
    @TableField("import_date")
    private String importDate;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;


}
