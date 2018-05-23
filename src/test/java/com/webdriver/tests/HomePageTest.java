package com.webdriver.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webdriver.pages.ExcelDriven;
import com.webdriver.pages.Login;

import resources.TestBase;



public class HomePageTest extends TestBase {
	public static WebDriver driver;
	
	public static Logger log=LogManager.getLogger(TestBase.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
	}

	@Test(priority=1)
	public void updatedata()
	{
		String xlsFilePath=prop.getProperty("xlsFilePath");
		String Sheetname="Sheet1";
		Login signin=new Login(driver);
	    String[][] obj=signin.createdata();
		ExcelDriven excel=new ExcelDriven();
		excel.updateXLSRow(xlsFilePath, Sheetname, obj);
	}

	@Test(priority=2, dataProvider="getData")
	public void LoginFox(String Username,String Password,String Text) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

				//Login Button click
				/*String Username=prop.getProperty("UserName");
				String Password="Password";
				*/
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		Thread.sleep(10000);
		
				Login signin=new Login(driver);
				signin.LoginClick(Username, Password);
				System.out.println(Text);
				log.info(Text);
				//Write a code to login and write a method called LoginClick and isUserLoggedOut which returns boolean.
				//Assert.assertTrue(signin.LoginClick(Username, Password), "User failed to login");
				//Assert.assertFalse(isUserLoggedOut());
				
				//driver.close();
				
		
	}
	@AfterTest
	public void teardown()
	{
		 driver.close();
		 driver=null;
	}
	
	//Both parametrisation and datadriving  can be achievable with dataprovider annotation 
	//in testng
	@ DataProvider
	public Object[][] getData() throws Exception
	{
		//Row stands for how many different data types test should run
		//column stands for how many values per each test
		//
		/*Object[][] data=new Object[2][3];
		//0th row 
		data[0][0]="non restricted user";//username
		data[0][1]="1223";//password
		data[0][2]="Restricted User";//text
		
		//1st row
		data[1][0]="Restricted user";
		data[1][1]="45678";
		data[1][2]="Non restricted user";*/
		
		String xlsFilePath=prop.getProperty("xlsFilePath");
		String Sheetname="Sheet1";
		ExcelDriven excel=new ExcelDriven();
        Object[][] data =excel.getCellData(xlsFilePath,Sheetname);
       
		
		return data;
		
	}


}
