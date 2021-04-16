package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name = "user_name")
	private WebElement usertbx;
	
	@FindBy(name = "user_password")
	private WebElement pwdtbx;
	
	@FindBy(id = "submitButton")
	private WebElement lginbtn;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}

	public WebElement getUsertbx() {
		return usertbx;
	}

	public WebElement getPwdtbx() {
		return pwdtbx;
	}

	public WebElement getLginbtn() {
		return lginbtn;
	}
	
	public void login(String un, String pw) {
		usertbx.sendKeys(un);
		pwdtbx.sendKeys(pw);
		lginbtn.click();
	}
	
	
}
