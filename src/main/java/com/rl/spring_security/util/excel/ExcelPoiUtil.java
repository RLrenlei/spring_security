package com.rl.spring_security.util.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ren
 * @description 用poi操作Excel
 * @date 2022/1/5 16:31
 */
public class ExcelPoiUtil {

    private static Workbook workbook;


    public Workbook getWorkbook(String fileName) {
        if (fileName.endsWith(".xls")) {
            workbook = new HSSFWorkbook();
        } else if (fileName.endsWith(".xlsx")) {
            workbook = new XSSFWorkbook();
        } else {
            return null;
        }
        return workbook;
    }

    public Sheet getSheet(Workbook workbook) {
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
     * @description 处理标题,标题设置xxx4表示xxx合并4个单元格
     * @date  2022/1/5 16:45
     * @params [tittleList]
     * @return org.apache.poi.ss.usermodel.Workbook
     */
    public Workbook setTittle(List<String> tittleList) {
        if (workbook == null) {
            return null;
        }
        CellStyle cellStyle = getCellStyle();
        Sheet sheet = workbook.createSheet();
        int n = tittleList.size();
        for (int i = 0; i < n; i++) {
            List<String> rowTittle = Arrays.asList(tittleList.get(i).split(","));
            Row row = sheet.createRow(i);
            for (int j = 0; j < rowTittle.size(); j++) {
                String cellTittle = rowTittle.get(j);
                String numStr = cellTittle.substring(cellTittle.length() - 1);
                boolean isNumeric = isNumeric(numStr);
                if (isNumeric && Integer.parseInt(numStr) > 0) {
                    int num = Integer.parseInt(numStr);
                    Cell cell = row.createCell(j);
                    cell.setCellValue(cellTittle.substring(0,cellTittle.length()-1));

                    cell.setCellStyle(cellStyle);
                    for (int k = 1; k < num; k++) {
                        Cell cell1 = row.createCell(j+k);
                        cell1.setCellValue("");
                        cell1.setCellStyle(cellStyle);
                    }
                } else {
                    Cell cell = row.createCell(j);
                    cell.setCellValue(cellTittle);
                    cell.setCellStyle(cellStyle);
                }
            }
        }
        return workbook;
    }

    public static CellStyle getCellStyle() {
        if (workbook == null)
            return null;
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        Font font = workbook.createFont();
        font.setFontName("黑体");
        font.setBold(true);
        font.setFontHeightInPoints((short) 15);
        cellStyle.setFont(font);
        return cellStyle;
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

}
