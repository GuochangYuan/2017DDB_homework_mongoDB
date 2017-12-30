package common.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelTools {
	
	public static void exportExcel(List excelableList,String sheetName,String fileName,HttpServletResponse response) throws IOException{
		exportExcel(excelableList, sheetName, fileName, response,null);
	}
	
	public static void exportExcel(List excelableList,String sheetName,String fileName,HttpServletResponse response,Integer mode) throws IOException{
		HSSFWorkbook wb=new HSSFWorkbook();
		Map<String, CellStyle> styles =createStyles(wb);
		if(excelableList!=null && excelableList.size() > 0){
	        
			ExcelAble first = (ExcelAble)excelableList.get(0);
			HSSFSheet sheet = null;
			if(StringUtils.isNotBlank(sheetName)){
				sheet = wb.createSheet(sheetName);
			}else{
				sheet = wb.createSheet(first.sheetName());
			}
			
			String[] rowNames = first.excelColumns();
			if(mode != null){
				rowNames = first.excelColumns(mode);
			}
			HSSFRow trow=sheet.createRow(0);
			for (int i = 0; i < rowNames.length; i++) {
				HSSFCell cell=trow.createCell(i);
				cell.setCellStyle(styles.get("title"));
				cell.setCellValue(rowNames[i]);
			}
			int count = excelableList.size();
			for(int i=0;i<count;i++ ){
				ExcelAble e = (ExcelAble)excelableList.get(i);
				HSSFRow row=sheet.createRow(i + 1);
				for (int j = 0; j < rowNames.length; j++) {
					HSSFCell cell=row.createCell(j);
					cell.setCellStyle(styles.get("cell"));
					String rowName = rowNames[j];
					Object value = e.rowMap().get(rowName);
					if(value == null){
						value = "";
					}else{
						if(value instanceof String){
							cell.setCellValue(value.toString());
						}else if(value instanceof Integer){
							cell.setCellValue((Integer)value);
						}else if(value instanceof Double){
							cell.setCellValue((Double)value);
						}else if(value instanceof Date){
							cell.setCellValue((Date)value);
						}else if(value instanceof Long){ 
							cell.setCellValue((Long)value);
						}else { 
							cell.setCellValue(value.toString());
						}
					}
					
				}
			}
			OutputStream out = response.getOutputStream();
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
		    response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
			wb.write(out);
			out.close();
		}
	}
	
	/**
     * 设置单元格的格式
     */
    /**
     * @param wb
     * @return
     */
    private static Map<String, CellStyle> createStyles(Workbook wb){
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();

        short borderColor = IndexedColors.GREY_50_PERCENT.getIndex();
             
      //正文title样式
        CellStyle style;
        style = wb.createCellStyle();
        // 居中
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        //边框
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
        //设置字体
        Font titleFont = wb.createFont();
        titleFont.setFontName("宋体");
        titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        //设置字体大小
        titleFont.setFontHeightInPoints((short)10);
        //设置颜色
        titleFont.setColor(IndexedColors.AUTOMATIC.getIndex());
        //设置样式的字体
        style.setFont(titleFont);
        styles.put("title", style);
            
        //标题行样式
        CellStyle styleName;
        styleName = wb.createCellStyle();
        styleName.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        styleName.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        styleName.setBorderTop(HSSFCellStyle.BORDER_THIN);
        styleName.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        styleName.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        styleName.setBorderRight(HSSFCellStyle.BORDER_THIN);
        Font nameFont = wb.createFont();
        nameFont.setFontName("宋体");
        nameFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        nameFont.setFontHeightInPoints((short)10);
        nameFont.setColor(IndexedColors.AUTOMATIC.getIndex());
        styleName.setFont(nameFont);
        styles.put("name", styleName);
        
        //标题行动态数据样式
        CellStyle styleData;
        styleData = wb.createCellStyle();
        styleData.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        styleData.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        styleData.setBorderTop(HSSFCellStyle.BORDER_THIN);
        styleData.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        styleData.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        styleData.setBorderRight(HSSFCellStyle.BORDER_THIN);
        Font dataFont = wb.createFont();
        dataFont.setFontName("宋体");
        dataFont.setFontHeightInPoints((short)10);
        dataFont.setColor(IndexedColors.AUTOMATIC.getIndex());
        styleData.setFont(dataFont);
        styleData.setWrapText(true);
        styles.put("data", styleData);
        
        //单元格样式
        CellStyle styleCell;
        styleCell = wb.createCellStyle();
        styleCell.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        styleCell.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        styleCell.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        styleCell.setBorderRight(HSSFCellStyle.BORDER_THIN);
        styleCell.setBorderTop(HSSFCellStyle.BORDER_THIN);
        styleCell.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        Font cellFont = wb.createFont();
        cellFont.setFontName("宋体");
        cellFont.setFontHeightInPoints((short)8);
        cellFont.setColor(IndexedColors.AUTOMATIC.getIndex());
        styleCell.setFont(dataFont);
        styleCell.setWrapText(true);
        styles.put("cell", styleCell);
        
        return styles;
    }
	
}
