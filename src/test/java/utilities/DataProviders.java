package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = "./testData/LoginData.xlsx";      //taking xl file from "testData" folder
		
		ExcelUtility xlutil = new ExcelUtility(path);  //creating an object for xlutility and giving path

		int totalrows = xlutil.getRowCount("sheet1");
		int totalcols = xlutil.getCellCount("sheet1", 1);

		String logindata[][] = new String[totalrows][totalcols];  // created for 2Dimensional(2D) array which can store 
		
		for (int i = 1; i<= totalrows; i++) { //1  //read  the data from xl storing in 2D array
			for (int j = 0; j<totalcols; j++) {  //0  // 1 is row, j is col
				logindata[i-1][j]=xlutil.getCellData("sheet1", i, j);  //1,0
			}
		}
		return logindata;  //returning 2D array
			
		}

	}


