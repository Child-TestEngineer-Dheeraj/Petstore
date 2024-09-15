package api.Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {

	@DataProvider(name = "CreateUser")
	public String[][] CreateUserData() throws Exception {
		String Path = System.getProperty("user.dir") + "//TestData//Data_Test.xlsx";
		excelUtility eu = new excelUtility(Path);
		int rowCount = eu.getRowCount("CreateUser");
		int cellCount = eu.getCellCount("CreateUser", 1);
		String[][] createuserdata = new String[rowCount][cellCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				createuserdata[i - 1][j] = eu.getCellData("CreateUser", i, j);
			}
		}
		return createuserdata;
	}

	// @DataProvider(name="usernames")
	@Test
	public String[] CreatedUserName() throws Exception {
		String Path = System.getProperty("user.dir") + "//TestData//Data_Test.xlsx";
		excelUtility eu = new excelUtility(Path);
		int rowCount = eu.getRowCount("CreateUser");
		String[] createusernamedata = new String[rowCount];
		for (int i = 1; i <= rowCount; i++) {
			createusernamedata[i - 1] = eu.getCellData("CreateUser", i, 1);
		}
		return createusernamedata;
	}

}
