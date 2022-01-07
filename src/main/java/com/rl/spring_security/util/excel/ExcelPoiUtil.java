package com.rl.spring_security.util.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author Ren
 * @description 用poi操作Excel
 * @date 2022/1/5 16:31
 */
public class ExcelPoiUtil {

    private static Workbook workbook;


    /**
     * @author Ren
     * @description //获得相应版本的workbook
     * @date  2022/1/5 17:54
     * @params [fileName]
     * @return org.apache.poi.ss.usermodel.Workbook
     */
    public static Workbook getWorkbook(String fileName) {
        if (fileName.endsWith(".xls")) {
            workbook = new HSSFWorkbook();
        } else if (fileName.endsWith(".xlsx")) {
            workbook = new XSSFWorkbook();
        } else {
            return null;
        }
        return workbook;
    }

    /**
     * @author Ren
     * @description 根据workbook来创建对应的sheet
     * @date  2022/1/5 17:54
     * @params [org.apache.poi.ss.usermodel.Workbook]
     * @return org.apache.poi.ss.usermodel.Sheet
     */
    public static Sheet getSheet(Workbook workbook) {
        Sheet sheet;
        if (workbook != null) {
            sheet = workbook.createSheet();
        } else {
            sheet = null;
        }
        return sheet;
    }

    /**
     * @author Ren
     * @description 处理标题,使用时在标题后面直接添加&11表示合并11个单元格
     * @date  2022/1/5 16:45
     * @params [tittleList]
     * @return org.apache.poi.ss.usermodel.Workbook
     */
    public static Workbook setTittle(List<String> tittleList, Workbook workbook) {
        if (workbook == null) {
            return null;
        }
        CellStyle cellStyle = getCellStyle(setFont());
        Sheet sheet = getSheet(workbook);
        // 存储每一列列宽
        Map<Integer,Integer> maxWidthMap = new HashMap<>();
        int n = tittleList.size();
        for (int i = 0; i < n; i++) {
            String[] rowTittle = tittleList.get(i).split(",");
            Row row = sheet.createRow(i);
            // 每一行下一个单元格索引
            int cellIndex = 0;
            for (String cellTittle : rowTittle) {
                List<String> cellList = new ArrayList<>(Arrays.asList(cellTittle.split("&")));
                // 判断是否包含数字，通过该数字来合并单元格
                String numStr = cellList.size() > 1 ? cellList.get(cellList.size() - 1) : "";
                boolean isNumeric = isNumeric(numStr);

                if (isNumeric && Integer.parseInt(numStr) > 0) {
                    int num = Integer.parseInt(numStr);
                    Cell cell = row.createCell(cellIndex);
                    // 去除标题中人为加的合并单元格数字
                    cellList.remove(cellList.size() - 1);
                    cell.setCellValue(cellList.get(0));
                    // 组装宽度map
                    buildWidthMap(cell,maxWidthMap,cellIndex);
                    cell.setCellStyle(cellStyle);
                    for (int k = 1; k < num; k++) {
                        Cell cell1 = row.createCell(cellIndex + k);
                        cell1.setCellValue("");
                        cell1.setCellStyle(cellStyle);
                    }

                    // 合并单元格
                    if (num > 1) {
                        CellRangeAddress cellRangeAddress = new CellRangeAddress(i, i, cellIndex, cellIndex + num - 1);
                        sheet.addMergedRegion(cellRangeAddress);
                    }
                    cellIndex += num;
                } else {
                    Cell cell = row.createCell(cellIndex);
                    cell.setCellValue(cellTittle);
                    cell.setCellStyle(cellStyle);
                    buildWidthMap(cell,maxWidthMap,cellIndex);
                    cellIndex += 1;
                }
            }
        }

        // 设置对应列宽,一般取标题最后一行的列数为对应的列数
        for (Map.Entry<Integer,Integer> entry : maxWidthMap.entrySet()) {
            sheet.setColumnWidth(entry.getKey(),entry.getValue());
        }
        return workbook;
    }

    /**
     * @author Ren
     * @description 组装宽度map
     * @date  2022/1/6 11:59
     * @params [cell, maxWidthMap, cellIndex]
     * @return void
     */
    private static void buildWidthMap(Cell cell, Map<Integer,Integer> maxWidthMap, Integer cellIndex) {
        int cellLength = cell.getStringCellValue().getBytes(StandardCharsets.UTF_8).length;
        if (maxWidthMap.size() == 0 || maxWidthMap.get(cellIndex) == null
                || cellLength * 256 - 100 > maxWidthMap.get(cellIndex)) {
            maxWidthMap.put(cellIndex, cellLength * 256 - 100);
        }
    }

    /**
     * @author Ren
     * @description //设置标题样式
     * @date  2022/1/5 17:53
     * @params []
     * @return org.apache.poi.ss.usermodel.CellStyle
     */
    public static CellStyle getCellStyle(Font font) {
        if (workbook == null)
            return null;
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setFont(font);
        return cellStyle;
    }

    public static Font setFont() {
        Font font = workbook.createFont();
        font.setFontName("黑体");
//        font.setBold(true);
        font.setFontHeightInPoints((short) 13);
        return font;
    }

    /**
     * @author Ren
     * @description 判断是否为数字
     * @date  2022/1/5 17:41
     * @params [str]
     * @return boolean
     */
    public static boolean isNumeric(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * @author Ren
     * @description 组装datalist数据
     * @date  2022/1/6 14:23
     * @params [dataList, workbook]
     * @return void
     */
    public static void buildDataList(List<Object> dataList, Sheet sheet) {
        if (sheet == null)
            return;
        dataList.forEach(obj ->{
//            sheet.createRow()
        });
    }

    public static void main(String[] args) {
        List<String> tittleList = new ArrayList<>();
        String title = "证券投资基金估值表&11";
        tittleList.add(title);
        title = "净值消息是否已确认:已确认&2,单位净值:1.001&2,估值日期:2019-05-01&3,单位:元";
        tittleList.add(title);
        title = "科目代码,科目名称,数量,单位成本,成本,成本占净值%,市价,市值,市值占净值%,估值增值,停牌信息";
        tittleList.add(title);
        String fileName = "估值表.xlsx";
        String PATH = "D:/myFile";
        File file = new File(PATH, fileName);
        Workbook workbook = getWorkbook(fileName);
        workbook = setTittle(tittleList,workbook);
//        List<Object> dataList = new ArrayList<>();
//        buildDataList(dataList, workbook);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            assert workbook != null;
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
