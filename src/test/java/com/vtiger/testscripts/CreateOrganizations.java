package com.vtiger.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.vtiger.generics.FileUtility;
import com.vtiger.generics.JavaUtility;
import com.vtiger.generics.WebDriverUtility;
import com.vtiger.pom.CreateOrgPage;
import com.vtiger.pom.LoginPage;
import com.vtiger.pom.OrganizationsPage;

public class CreateOrganizations {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	public static void main(String[] args) throws Exception {
		JavaUtility ju = new JavaUtility();
		FileUtility fu = new FileUtility();
		String name = fu.getExceldata("CreateOrganisation", 1, 0);
		String ExpectedOrgname=name+ju.randomNumber();
		System.out.println(ExpectedOrgname);

		WebDriver driver=new ChromeDriver();
		WebDriverUtility wu = new WebDriverUtility();
		wu.maximize(driver);
		wu.implicitWait(driver);


		String url = fu.getPropertydata("url");
		String un = fu.getPropertydata("username");
		String pw = fu.getPropertydata("password");

		driver.get(url);
		OrganizationsPage op = new OrganizationsPage(driver);
		CreateOrgPage co = new CreateOrgPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.login(un, pw);
	
		op.getOrgLink().click();
		op.getCreatOrgLink().click();
		co.getOrgnametbx().sendKeys(ExpectedOrgname);

		String phoneNo = fu.getExceldata("CreateOrganisation", 1, 1);
		co.getPhonNotbx().sendKeys(phoneNo);

		String Industry = fu.getExceldata("CreateOrganisation", 1, 2);
		WebElement indAdrs = co.getIndustryAdrs();
		wu.selectTheElement(indAdrs, Industry);												
		

		String accounttype = fu.getExceldata("CreateOrganisation", 1, 3);
		WebElement accountAdrs = co.getAccountAdrs();
		wu.selectTheElement(accountAdrs, accounttype);

		String Rating = fu.getExceldata("CreateOrganisation", 1, 4);
		WebElement ratingAdrs = co.getRatingAdrs();
		wu.selectTheElement(ratingAdrs, Rating);

		co.getSavebtn().click();

		wu.refresh(driver);

		op.getOrgLink().click();
		op.getEntersearchtbx().sendKeys(ExpectedOrgname);

		WebElement orgbox = op.getOrgDrpdwn();
		wu.selectTheElement(orgbox, 2);

		op.getSearchBtn().click();

		WebElement orgname = driver.findElement(By.xpath("//a[@title='Organizations' and text()='"+ExpectedOrgname+"']"));
		wu.explicitWait(driver, orgname);

		String actualOrgName = orgname.getText();
		Assert.assertEquals(ExpectedOrgname,actualOrgName);
		System.out.println("Successfully found "+ExpectedOrgname);
		driver.quit();
	}

}
