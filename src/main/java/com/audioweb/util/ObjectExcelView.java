package com.audioweb.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* 导入到EXCEL
* 类名称：ObjectExcelView.java
 */
public class ObjectExcelView extends AbstractXlsView {
	private String filename = Tools.date2Str( new Date(), "yyyyMMddHHmmss");
	public ObjectExcelView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

	}

	public ObjectExcelView(String fileName) {
		// TODO Auto-generated constructor stub
		this.filename += "_"+fileName;
	}
	@Deprecated
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HSSFSheet sheet;
		HSSFCell cell;
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename="+filename+".xls");
		sheet = workbook.createSheet("sheet1");

		HSSFDataFormat  format = workbook.createDataFormat();

		List<String> titles = (List<String>) model.get("titles");
		int len = titles.size();
		HSSFCellStyle headerStyle = workbook.createCellStyle(); //标题样式
		HSSFFont headerFont = workbook.createFont();	//标题字体
		headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		headerFont.setFontHeightInPoints((short)11);
		headerStyle.setFont(headerFont);
		short width = 20,height=25*20;
		sheet.setDefaultColumnWidth(width);
		for(int i=0; i<len; i++){ //设置标题
			String title = titles.get(i);
//			cell = getCell(sheet, 0, i);
//			cell.setCellStyle(headerStyle);
//			setText(cell,title);
		}
		sheet.getRow(0).setHeight(height);

		HSSFCellStyle contentStyle = workbook.createCellStyle(); //内容样式
		contentStyle.setDataFormat(format.getFormat("@"));
		List<PageData> varList = (List<PageData>) model.get("varList");
		int varCount = varList.size();
		for(int i=0; i<varCount; i++){
			PageData vpd = varList.get(i);
			for(int j=0;j<len;j++){
				String varstr = vpd.getString("var"+(j+1)) != null ? vpd.getString("var"+(j+1)) : "";
//				cell = getCell(sheet, i+1, j);
//				cell.setCellStyle(contentStyle);
//				setText(cell,varstr);
			}

		}

	}

}
