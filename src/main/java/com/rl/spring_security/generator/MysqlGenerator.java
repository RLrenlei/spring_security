package com.rl.spring_security.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Ren
 * @description 自动生成代码工具
 * @date 2022/6/2 15:30
 */
@Slf4j
public class MysqlGenerator {
    protected static String URL = "jdbc:mysql://localhost:3306/test?useUnicode=true"
            + "&characterEncoding=UTF-8&serverTimezone=UTC";
    protected static String USERNAME = "root";
    protected static String PASSWORD = "root";

    protected static DataSourceConfig.Builder DATA_SOURCE_CONFIG = new
            DataSourceConfig.Builder(URL, USERNAME, PASSWORD);

    public static void main(String[] args) {
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                .globalConfig((scanner, builder) ->
                        builder.author(scanner.apply("请输入作者名称？"))
                                .enableSwagger()
                                .fileOverride()
                                .outputDir(System.getProperty("user.dir") + "\\src\\main\\java")
                                .commentDate("yyyy-MM-dd")
                                .dateType(DateType.TIME_PACK)
                )
                .packageConfig((builder) ->
                       builder.parent("com.rl.spring_security")
                                .entity("entity")
                                .service("service")
                                .serviceImpl("service.impl")
                                .xml("mapper.xml")
                                .pathInfo(Collections.singletonMap(OutputFile.xml,
                                        System.getProperty("user.dir") +
                                        "\\src\\main\\resources\\mapper"))
                )
                .injectionConfig((builder) ->
                        builder.beforeOutputFile(
                                (a, b) -> log.warn("tableInfo: {}", a.getEntityName())
                        )
                )
                .strategyConfig((scanner, builder) ->
                        builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔?所有输入all")))
                                .addTablePrefix("tb_")
                                .entityBuilder()
                                .enableChainModel()
                                .enableLombok()
                                .enableTableFieldAnnotation()
                                .addTableFills(
                                        new Column("create_time", FieldFill.INSERT)
                                )
                                .controllerBuilder()
                                .enableRestStyle()
                                .enableHyphenStyle()
                                .build()
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();

    }

    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }

}
