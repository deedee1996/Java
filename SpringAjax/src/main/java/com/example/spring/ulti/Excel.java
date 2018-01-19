package com.example.spring.ulti;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.core.io.FileSystemResource;

import com.example.spring.model.Product;

public class Excel {

	private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
		
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setColor(IndexedColors.BLUE.index);
        font.setFontName("Arial");
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        
        
        return style;
    }
	
	public Excel(HashMap<String, Product> product) throws IOException {
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Export");
		
		int rownum = 1;
		Cell cell;
		Row row;
		
		HSSFCellStyle style = createStyleForTitle(workbook);
		row = sheet.createRow(rownum);
		
		sheet.setColumnWidth(1, 4000);
		sheet.setColumnWidth(2, 5000);
		sheet.setColumnWidth(3, 3000);
		
		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("Mã sản phẩm");
		cell.setCellStyle(style);
		
		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Tên sản phẩm");
		cell.setCellStyle(style);
		
		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("Số lượng");
		cell.setCellStyle(style);
		
		
			for(String k : product.keySet()) {
				
				rownum++;
				row = sheet.createRow(rownum);
				
				cell = row.createCell(1, CellType.STRING);
				cell.setCellValue(product.get(k).getId());
				
				cell = row.createCell(2, CellType.STRING);
				cell.setCellValue(product.get(k).getName());
				
				cell = row.createCell(3, CellType.STRING);
				cell.setCellValue(product.get(k).getAmount());
				
			}
			
		File file = new File("\\resources/report.xls");
		
		FileSystemResource excel = new FileSystemResource(file);
		
		System.out.println(excel.getPath());
		System.out.println(excel.getURI());
		
		System.out.println(excel.getFile());
		file.getParentFile().mkdirs();
		
		FileOutputStream outFile = new FileOutputStream(file);
		workbook.write(outFile);
		
		System.out.println("Create File " + file.getAbsolutePath());
		
	}

}
