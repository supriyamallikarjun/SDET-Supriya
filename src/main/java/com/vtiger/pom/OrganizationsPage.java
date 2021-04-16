package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement creatOrgLink;

	@FindBy(xpath = "//a[@href='index.php?module=Accounts&action=index']")
	private WebElement orgLink;

	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement entersearchtbx;

	@FindBy(xpath = "//div[@id='basicsearchcolumns_real']/select[@name='search_field']")
	private WebElement orgDrpdwn;

	@FindBy(xpath = "//input[@name='submit']")
	private WebElement searchBtn;
	
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreatOrgLink() {
		return creatOrgLink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getEntersearchtbx() {
		return entersearchtbx;
	}

	public WebElement getOrgDrpdwn() {
		return orgDrpdwn;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

}
