package tju.scs.jys;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public Excel(){
		
	}
	
	public  List<List<String>>  ObtainExcel(String filePath) {
		List<List<String>> res = new ArrayList<List<String>>();
		
		try {
			InputStream inputStream= new FileInputStream(filePath);
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
			
			// obtain every sheet
			for (int numOfSheet = 0; numOfSheet < xssfWorkbook.getNumberOfSheets(); numOfSheet++) {
				XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numOfSheet);
				if (xssfSheet == null) {
					continue;
				}
				
				// obtain the sheet opened now
				// skip the first two rows, which are useless
				for (int numOfRow = 2; numOfRow <= xssfSheet.getLastRowNum(); numOfRow++) {
					XSSFRow xssfRow = xssfSheet.getRow(numOfRow);
					if (xssfRow != null) {
						List<String> row=new ArrayList<String>();
						//skip the first column
						XSSFCell one = xssfRow.getCell(1);
						row.add(ObtainValue(one));
						XSSFCell two = xssfRow.getCell(2);
						row.add(ObtainValue(two));
					    XSSFCell three = xssfRow.getCell(3);
					    row.add(ObtainValue(three));
					    res.add(row);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	private  String ObtainValue(XSSFCell xssfRow) {
		if(xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
			return String.valueOf(xssfRow.getBooleanCellValue());
		}else if(xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
			DecimalFormat df = new DecimalFormat("0");
			return df.format(xssfRow.getNumericCellValue());	
		}else{
			return String.valueOf(xssfRow.getStringCellValue());
		}
	}
}
