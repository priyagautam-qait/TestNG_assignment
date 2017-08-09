package org.qait.testng_assignment;
import java.io.File;
import java.io.IOException;
import org.jopendocument.dom.spreadsheet.MutableCell;

import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;
public class ExcelReader {
	public Object[][] getDetailsFromExcel() throws IOException
	{
		
		File file=new File("/home/priyagautam/Desktop/email_data.ods");
		Sheet sheet = SpreadSheet.createFromFile(file).getSheet(0);
		int numOfCol = sheet.getColumnCount();
		int numOfRow = sheet.getRowCount();
	    MutableCell cell=null;
	    Object [][] array=new Object[numOfRow][3];
	    for(int i= 0; i < numOfRow; i++)
        {
	    	
          //Iterating through each column
          int j;
          for(j = 0;j < numOfCol; j++)
          {
        	  
        	    cell = sheet.getCellAt(j, i);
        		array[i][j]=cell.getValue().toString();	
        		//System.out.print(array[i][j]+"||");
         }
	          // System.out.println();
	          

	    }
	    return array;

		}
	

}
