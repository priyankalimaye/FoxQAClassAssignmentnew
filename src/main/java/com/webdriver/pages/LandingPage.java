package com.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.webdriver.repository.Locators;

public class LandingPage {
public WebDriver driver;

@FindBy(how = How.XPATH, using = Locators.TEXT)
public WebElement foxtext;

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public WebElement getTitle() {
		
		PageFactory.initElements(driver, this);
		
		return foxtext;
		// TODO Auto-generated method stub
		
		
		
	}

	

}
