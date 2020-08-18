package com.h3c.platform.util;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public  class AbstractExcelReader implements ExcelReader{


    protected Workbook workbook;

    protected Sheet currentSheet;

    protected Integer currentSheetIndex = 0;

    protected Row currentRow;

    protected Integer currentRowIndex = 0;

    protected Cell currentCell;

    protected Integer currentCellIndex = 0;

    public AbstractExcelReader() {
    }

    public AbstractExcelReader(File file) throws IOException {
        checkExcelValid(file);
        initWorkBook(file);
        currentSheet = workbook.getSheetAt(currentSheetIndex);
        currentRow = currentSheet.getRow(currentRowIndex);
        currentCell = currentRow.getCell(currentCellIndex);
    }

    public AbstractExcelReader(InputStream inputStream,String fileName) throws IOException {
        initWorkBook(inputStream,fileName);
        currentSheet = workbook.getSheetAt(currentSheetIndex);
        currentRow = currentSheet.getRow(currentRowIndex);
        currentCell = currentRow.getCell(currentCellIndex);
    }



    /**
     * 判断Excel文件是否有效,无效时抛出异常
     *
     * @param file
     * @throws Exception
     */
    @Override
    public  void checkExcelValid(File file) throws IOException {
        // System.out.println("filename:" + file.getName());
        if (!file.exists()) {
            // 文件不存在
            throw new IOException("文件不存在");
        } else if (!(file.isFile() && (file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX)))) {
            throw new IOException("不是标准的Excel文件");
        }
    }

    /**
     * 初始化工作簿 文件方式
     * @param file
     * @throws IOException
     */
    @Override
    public void initWorkBook(File file) throws IOException {
        InputStream in = new FileInputStream(file);
        if (file.getName().endsWith(EXCEL_XLS)) {// Excel2003及以下
            workbook = new HSSFWorkbook(in);
        } else if (file.getName().endsWith(EXCEL_XLSX)) {// Excel2007及以上
            workbook = new XSSFWorkbook(in);
        }
    }

    /**
     * 初始化工作部 流方式
     * @param inputStream
     * @param fileName
     * @throws FlowableException
     * @throws IOException
     */
    @Override
    public  void initWorkBook(InputStream inputStream, String fileName) throws IOException {
        if (!fileName.endsWith(EXCEL_XLS) && !fileName.endsWith(EXCEL_XLSX)) {
            throw new IOException("不是标准的Excel文件");
        }
        if (fileName.endsWith(EXCEL_XLS)) {// Excel2003及以下
            workbook = new HSSFWorkbook(inputStream);
        } else if (fileName.endsWith(EXCEL_XLSX)) {// Excel2007及以上
            workbook = new XSSFWorkbook(inputStream);
        }
    }

    public Sheet nextSheet(){
        currentSheetIndex++;
        currentSheet = workbook.getSheetAt(currentSheetIndex);
        currentRowIndex = 1;
        currentRow = currentSheet.getRow(currentRowIndex);
        return currentSheet;
    }

    public boolean hasNextSheet(){
        Sheet nextSheet = workbook.getSheetAt(currentRowIndex + 1);
        if(nextSheet == null) return false;
        return true;
    }

    public Row nextRow(){
        currentRowIndex++;
        currentRow = currentSheet.getRow(currentRowIndex);
        currentCellIndex = 1;
        currentCell = currentRow.getCell(currentCellIndex);
        return currentRow;
    }

    public boolean hasNextRow(){
        Row row = currentSheet.getRow(currentRowIndex + 1);
        boolean flag = isEmptyRow(row);
        if(flag == true) return false;
        return true;
    }

    public Cell nextCell(){
        currentCellIndex++;
        currentCell = currentRow.getCell(currentCellIndex);
        return currentCell;
    }

    public boolean hasNextCell(){
        Cell cell = currentRow.getCell(currentCellIndex + 1);
        if(cell == null) return false;
        return true;
    }
    
    /**
        * 获取首行title
     * @return
     */
    public Row firstRow(){   
        currentRow = currentSheet.getRow(0);
        currentCellIndex = 1;
        currentCell = currentRow.getCell(currentCellIndex);
        return currentRow;
    }


/**
  *  判断是否为空行
  * @param row
  * @return
  */
    public boolean isEmptyRow(Row row){
        if(row == null || row.toString().isEmpty()){
            return true;
        }else{
            boolean flag = true;
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                if(cell.getCellTypeEnum() != CellType.BLANK){
                    flag = false;
                }
            }
            return flag;
        }

    }


    /**
     * 读取每个单元格Cell的value,对NUMERIC类型的Cell需要做特别处理
     *
     * @param cell
     * @return 返回Cell的value
     */
    public  String readCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        CellType type = cell.getCellTypeEnum();
        String cellValue;
        switch (type) {
            case BLANK:
                cellValue = "";
                break;
            case _NONE:
                cellValue = "";
                break;
            case ERROR:
                cellValue = "";
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case NUMERIC:
                // cellValue = String.valueOf(cell.getNumericCellValue());
                // 当Cell为日期类型(如2018-11-19)时，需要做特殊处理，否则解析出来的将会是一个距离1900年1月1日的天数(此时为43423)
                if (DateUtil.isCellDateFormatted(cell)) {// 日期类型
                    Date date = cell.getDateCellValue();
                    DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                    cellValue = formater.format(date);
                } else {// 货币类型 等等
                    // 如果Cell是科学计数法类型的数据或者货币类型时，获取不到想要的字符串，此时通过NumberToTextConverter工具类
                    // 的toText(...)方法可以解决该问题，获取字符串
                    cellValue = NumberToTextConverter.toText(cell.getNumericCellValue());
                }
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case FORMULA:
                cellValue = cell.getCellFormula();
                break;
            default:
                cellValue = "";
                break;
        }
        return cellValue;

    }
}
