package com.webdriver.tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webdriver.pages.LandingPage;

import resources.TestBase;

public class ValidateTitle extends TestBase {
public static WebDriver driver;
public static Logger log=LogManager.getLogger(TestBase.class.getName());
	/*@BeforeTest
	public void initialize() throws IOException {
			
		//Initialize
				driver=initializeDriver();
				
	}
		*/		
				
	@Test
	public void basePageNavigation() throws IOException, InterruptedException
	{
		
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
			LandingPage l=new LandingPage(driver);
			
			//compare the text from browser with the actual text
			//Actual value,Expected value
			Assert.assertEquals(l.getTitle().getText(), "Presents","Strings are not matching");
			//System.out.println("Test case is passed");
			log.info("Successfully validated Text Message");
			
			
			//Assert.assertTrue(arg0);
		
		//Now Run as Testng but after some testcases we will run everything from maven and integrate with jenkins
	} 
	@AfterTest
	public void teardown()
	{
		 driver.close();
		 driver=null;
	}
	
}
