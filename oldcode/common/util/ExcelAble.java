package common.util;

import java.util.Map;

public interface ExcelAble {
	
	public String[] excelColumns();
	
	public Map<String,Object> rowMap();
	
	
	public String sheetName();

	public String[] excelColumns(Integer mode);

}
