package com.webdriver.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdriver.repository.Locators;

public class Login {
	

	public WebDriver driver;
	@FindBy(how = How.XPATH, using = Locators.Login_Tab)
	public WebElement logintab;
	@FindBy(how = How.CSS, using = Locators.Account_Sign_in)
	public WebElement signin;
	@FindBy(how = How.XPATH, using = Locators.User_Name)
	public WebElement username;
	@FindBy(how = How.XPATH, using = Locators.Password)
	public WebElement password;
	@FindBy(how = How.CSS, using = Locators.Sign_In_Tab)
	public WebElement signin_tab;
		

	public Login(WebDriver driver)
	{
			this.driver=driver;
	}
		

	public boolean LoginClick(String Username,String Password )   {
	PageFactory.initElements(driver, this);
	WebDriverWait wait = new WebDriverWait(driver,60);
	wait.until(ExpectedConditions.elementToBeClickable(logintab)).click();
	wait.until(ExpectedConditions.elementToBeClickable(signin)).click();
	username.sendKeys(Username);
	password.sendKeys(Password);
	
	wait.until(ExpectedConditions.elementToBeClickable(signin_tab)).click();
	return false;
		

	}


	public String[][] createdata() {
		// TODO Auto-generated method stub
		
		String[][] data=new String[2][3];
		//0th row 
		data[0][0]="non restricted user";//username
		data[0][1]="1223";//password
		data[0][2]="Restricted User";//text
				
		//1st row
		data[1][0]="Restricted user";
		data[1][1]="45678";
		data[1][2]="Non restricted user";
					
		return data;
	}

}
