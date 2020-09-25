import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class j06_DataDrivenExcel {

	public static void main(String[] args) throws Exception {
		
		String xlPath, xlSheet;
		xlPath = "C:\\Users\\Mythili\\Documents\\Mythili\\SDET-March-ITeLearn\\TestData.xls";
		
		xlSheet = "DataSheet";
		
		String[][] xUC1;
		xUC1 = readXL(xlPath,xlSheet);
		
		double d = Double.parseDouble("103.45"); //Convert String to Double
		System.out.println(d);
		
		String d1 = String.valueOf(d); //Convert Double to String
		System.out.println(d1);
				
		xUC1[1][4] = "Pass";
		xUC1[2][4] = "Fail";
		xUC1[3][4] = "Not Executed";
		writeXLSheets(xlPath,xlSheet,0,xUC1);

	}
	
	public static String[][] readXL(String fPath, String fSheet) throws Exception{
		//Inputs: XL Path and XL Sheet name
		//Output: Two dimensional string array
		String[][] xData;
		int xRows, xCols;
		DataFormatter dataFormatter =  new DataFormatter();
		String cellValue;
		File myxl = new File(fPath);
		FileInputStream myStream = new FileInputStream(myxl);
		@SuppressWarnings("resource")
		HSSFWorkbook myWB = new HSSFWorkbook(myStream);
		HSSFSheet mySheet = myWB.getSheet(fSheet);
		xRows = mySheet.getLastRowNum()+1;
		xCols = mySheet.getRow(0).getLastCellNum();
		xData = new String[xRows][xCols];
		
		for(int i=0;i<xRows;i++) {
			HSSFRow row = mySheet.getRow(i);
			for(int j=0;j<xCols;j++) {
				cellValue =  "-";
				cellValue = dataFormatter.formatCellValue(row.getCell(j));
				if(cellValue!=null) {
					xData[i][j]=cellValue;
				}
			}
		}
		myxl = null; //Memory gets released
		return xData;
	}
	
	public static void writeXLSheets(String sPath, String iSheet, int sheetIndex, String[][] xData)
			throws Exception
	{
		HSSFWorkbook  wb,newWB;
		HSSFSheet osheet;
		File outFile = new File(sPath);
		/*
		CellStyle style = headingcellformat(wb);
		CellStyle style1 = datacellformat(wb);
		CellStyle style2 = passedcellformat(wb);
		CellStyle style3 = failedcellformat(wb);
		*/
		if ((outFile.isFile() == true)&&(outFile.exists()==true))
		{
			final InputStream is = new FileInputStream(outFile);
			try 
			{
				wb = new HSSFWorkbook(is);
				if((wb.getNumberOfSheets())== sheetIndex)
				wb.createSheet();
	
				if((wb.getSheetName(sheetIndex)).equalsIgnoreCase(iSheet))
				{					
					wb.removeSheetAt(sheetIndex);
					osheet=wb.createSheet(iSheet);
					wb.setSheetOrder(iSheet, sheetIndex);
					
					int xR_TS = xData.length;
				    int xC_TS = xData[0].length;
				   	for (int myrow = 0; myrow < xR_TS; myrow++)
				   	{				   		
				        HSSFRow row = osheet.createRow(myrow);
				        for (int mycol = 0; mycol < xC_TS; mycol++)
				        {
				        	HSSFCell cell = row.createCell(mycol);
       				       	// cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		    		       	cell.setCellValue(xData[myrow][mycol]);
		    		       	/*
		    		       	if(myrow==0)
		    		       		cell.setCellStyle(style);
		    		       	else
		    		       		cell.setCellStyle(style1);
		    		       	if((xData[myrow][mycol]).equals("Pass"))
		    		       		cell.setCellStyle(style2);
		    		       	else if((xData[myrow][mycol]).equals("Fail"))
	    		       			cell.setCellStyle(style3);
	    		       		*/		    		       	
		    		    }
				        FileOutputStream fOut = new FileOutputStream(outFile);
				        wb.write(fOut);
				        fOut.flush();
				        fOut.close();
				   	}//outerfor 	
				
				}//end if sheet exists
				else 
				{
					osheet=wb.createSheet(iSheet);
					wb.setSheetOrder(iSheet, sheetIndex);
					int xR_TS = xData.length;
				    int xC_TS = xData[0].length;
				   	for (int myrow = 0; myrow < xR_TS; myrow++)
				   	{
				   		HSSFRow row = osheet.createRow(myrow);
				   		for (int mycol = 0; mycol < xC_TS; mycol++)
				   		{
					       	HSSFCell cell = row.createCell(mycol);
					       	// cell.setCellType(HSSFCell.CELL_TYPE_STRING );
					       	cell.setCellValue(xData[myrow][mycol]);
					       	/*
		    		       	if(myrow==0)
		    		       		cell.setCellStyle(style);
		    		       	else
		    		       		cell.setCellStyle(style1);
		    		       		*/
					     }
				   		if (wb.getSheetName(wb.getNumberOfSheets()-1).equalsIgnoreCase("Sheet1")) 
				   			wb.removeSheetAt(wb.getNumberOfSheets()-1);
						FileOutputStream fOut = new FileOutputStream(outFile);
					    wb.write(fOut);
					    fOut.flush();
					    fOut.close();
				   	} 
				}
			} 
			finally 
			{ 
				is.close();
			}
		}//end of first if file exists
		else if (outFile.isFile() == false)
		{
			newWB = new HSSFWorkbook();
			HSSFSheet newsheet = newWB.createSheet(iSheet);
			int xR_TS = xData.length;
			int xC_TS = xData[0].length;
		   	for (int myrow = 0; myrow < xR_TS; myrow++) 
		   	{
		   		HSSFRow row = newsheet.createRow(myrow);
		        for (int mycol = 0; mycol < xC_TS; mycol++) 
		        {
		        	HSSFCell cell = row.createCell(mycol);
		        	// cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		        	cell.setCellValue(xData[myrow][mycol]);
		        	/*
    		       	if(myrow==0)
    		       		cell.setCellStyle(style);
    		       	else
    		       		cell.setCellStyle(style1);
    		       		*/
			    }
		        if (newWB.getSheetName(newWB.getNumberOfSheets()-1).equalsIgnoreCase("Sheet1")) 
		    	    newWB.removeSheetAt(newWB.getNumberOfSheets()-1);
		        FileOutputStream fOut = new FileOutputStream(outFile);
		        newWB.write(fOut);
		        fOut.flush();
		        fOut.close();
		   	}
		}	 

	} //end of writeXLSheets

}
