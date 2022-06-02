package com.rl.spring_security.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 客户端每日更新数据明细表
 * </p>
 *
 * @author RenLei
 * @since 2022-06-02
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("ppw_dataview")
@ApiModel(value = "PpwDataview对象", description = "客户端每日更新数据明细表")
public class PpwDataview implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，唯一标识")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("数据库id")
    @TableField("dbs_id")
    private Integer dbsId;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("表名")
    @TableField("table_name")
    private String tableName;

    @ApiModelProperty("表字段")
    @TableField("table_cols")
    private String tableCols;

    @ApiModelProperty("表主键")
    @TableField("table_pk")
    private String tablePk;

    @ApiModelProperty("表主键类型")
    @TableField("pk_type")
    private Integer pkType;

    @ApiModelProperty("最后导出id，暂时找不到使用的地方")
    @TableField("last_id")
    private String lastId;

    @ApiModelProperty("单页数量")
    @TableField("page_num")
    private Integer pageNum;

    @ApiModelProperty("表字段映射")
    @TableField("col_mapping")
    private String colMapping;

    @ApiModelProperty("转换表名")
    @TableField("export_name")
    private String exportName;

    @ApiModelProperty("导出数据源名称")
    @TableField("export_dbs")
    private String exportDbs;

    @ApiModelProperty("入库数量，入库行数")
    @TableField("update_num")
    private Integer updateNum;

    @ApiModelProperty("下载zip大小")
    @TableField("zip_size")
    private String zipSize;

    @ApiModelProperty("解压zip大小")
    @TableField("csv_size")
    private String csvSize;

    @ApiModelProperty("增量表数据的数据量，文件行数")
    @TableField("file_rows")
    private Integer fileRows;

    @ApiModelProperty("导出类型")
    @TableField("export_type")
    private String exportType;

    @ApiModelProperty("库名")
    @TableField("dbs_name")
    private String dbsName;

    @ApiModelProperty("昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty("用户名")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty("导出路径")
    @TableField("export_path")
    private String exportPath;

    @ApiModelProperty("数据库类型")
    @TableField("db_type")
    private String dbType;

    @ApiModelProperty("是否特殊")
    @TableField("special")
    private Integer special;

    @ApiModelProperty("入库完成时间")
    @TableField("import_time")
    private LocalDateTime importTime;

    @ApiModelProperty("数据入库日期")
    @TableField("import_date")
    private LocalDate importDate;

    @ApiModelProperty("入库花费时长，单位：秒")
    @TableField("spend_time")
    private String spendTime;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("是否有效")
    @TableField("isvalid")
    private Integer isvalid;


}
