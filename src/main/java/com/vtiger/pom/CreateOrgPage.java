package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage {

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement Orgnametbx;
	
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phonNotbx;
	
	@FindBy(name = "industry")
	private WebElement industryAdrs;
	
	@FindBy(name = "accounttype")
	private WebElement accountAdrs;
	
	@FindBy(name = "rating")
	private WebElement ratingAdrs;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public CreateOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgnametbx() {
		return Orgnametbx;
	}

	public WebElement getPhonNotbx() {
		return phonNotbx;
	}

	public WebElement getIndustryAdrs() {
		return industryAdrs;
	}

	public WebElement getAccountAdrs() {
		return accountAdrs;
	}

	public WebElement getRatingAdrs() {
		return ratingAdrs;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
}
