package com.h3c.platform.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface ExcelReader {

    // 2003版本 最大支持65536 行
     String EXCEL_XLS = "xls";
    // 2007 版本以上 最大支持1048576行
     String EXCEL_XLSX = "xlsx";

    /**
     * 检查文件格式
     * @param file
     * @throws FlowableException
     */
    void checkExcelValid(File file) throws Exception;

    /**
     * 初始化工作部 流方式
     * @param inputStream
     * @param fileName
     * @throws FlowableException
     * @throws IOException
     */
    void initWorkBook(InputStream inputStream, String fileName) throws Exception,IOException;

    /**
     * 初始化工作部 流方式
     * @param file
     * @throws FlowableException
     * @throws IOException
     */
    void initWorkBook(File file) throws Exception,IOException;
}
