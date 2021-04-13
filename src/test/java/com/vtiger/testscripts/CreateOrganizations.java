package com.vtiger.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.vtiger.generics.FileUtility;
import com.vtiger.generics.JavaUtility;
import com.vtiger.generics.WebDriverUtility;

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
			driver.findElement(By.name("user_name")).sendKeys(un);
			driver.findElement(By.name("user_password")).sendKeys(pw);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ExpectedOrgname);
			
			String phoneNo = fu.getExceldata("CreateOrganisation", 1, 1);
			driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phoneNo);
			
			String Industry = fu.getExceldata("CreateOrganisation", 1, 2);
			WebElement indAdrs = driver.findElement(By.name("industry"));
			wu.selectTheElement(indAdrs, Industry);
			
			String accounttype = fu.getExceldata("CreateOrganisation", 1, 3);
			WebElement accountAdrs = driver.findElement(By.name("accounttype"));
			wu.selectTheElement(accountAdrs, accounttype);
			
			String Rating = fu.getExceldata("CreateOrganisation", 1, 4);
			WebElement ratingAdrs = driver.findElement(By.name("rating"));
			wu.selectTheElement(ratingAdrs, Rating);
			
			
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			wu.refresh(driver);
			
			driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
			driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(ExpectedOrgname);
			
			WebElement orgbox = driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']/select[@name='search_field']"));
			wu.selectTheElement(orgbox, 2);
			
			driver.findElement(By.xpath("//input[@name='submit']")).click();
			
			WebElement orgname = driver.findElement(By.xpath("//a[@title='Organizations' and text()='"+ExpectedOrgname+"']"));
			wu.explicitWait(driver, orgname);
			
			String actualOrgName = orgname.getText();
			Assert.assertEquals(ExpectedOrgname,actualOrgName);
			System.out.println("Successfully found "+ExpectedOrgname);
			driver.quit();
	}

}
