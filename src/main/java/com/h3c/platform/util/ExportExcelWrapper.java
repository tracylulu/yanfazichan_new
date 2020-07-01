package com.h3c.platform.util;
import java.net.URLEncoder;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.h3c.platform.sysmgr.entity.OperationLog;
 
/**
 * 供网页端点击按钮，自动生成并下载Excel表
 *
 * @param <T>
 */
public class ExportExcelWrapper<T> extends ExportExcelUtil {
 
    /**
     * 导出带有头部标题行的Excel
     * 时间格式默认：yyyy-MM-dd hh:mm:ss
     *
     * @param fileName 生成的Excel文件名字(不要加后缀)
     * @param title    表格标题
     * @param headers  头部标题集合
     * @param dataset  数据集合
     * @param response
     * @param version  2003 或者 2007，不传时默认生成2003版本
     * @param isLog   是否记录日志 true记录，false不记录
     * @param keyName  主键名（记日志用，实体字段）
     */
    public StringBuffer exportExcel(String fileName, String title, String[] headers,String[] column, Collection<T> dataset, HttpServletResponse response, String version,boolean isLog, String keyName )throws Exception {
       
            response.setContentType("application/vnd.ms-excel");
            String suffix = null;
            if (StringUtils.isBlank(version) || EXCEL_FILE_2003.equals(version.trim())) {
                suffix = ".xls";
            } else {
                suffix = ".xlsx";
            }
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + suffix);
            Workbook workbook = null;
            if (StringUtils.isBlank(version) || EXCEL_FILE_2003.equals(version.trim())) {
                workbook = new HSSFWorkbook();
            } else {
                workbook = new XSSFWorkbook();
            }
            return  exportExcel(workbook, title, headers,column, dataset, response.getOutputStream(), "yyyy-MM-dd HH:mm:ss",isLog, keyName);
       
    }
 
}