package com.vtiger.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.generics.FileUtility;
import com.vtiger.generics.JavaUtility;
import com.vtiger.generics.WebDriverUtility;


public class CreateContact {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		WebDriverUtility wu = new WebDriverUtility();
		wu.maximize(driver);
		wu.implicitWait(driver);
		
		FileUtility fu = new FileUtility();
		String url = fu.getPropertydata("url");
		String un = fu.getPropertydata("username");
		String pw = fu.getPropertydata("password");
		
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		WebElement adrs = driver.findElement(By.name("salutationtype"));
		wu.selectTheElement(adrs, "Ms.");
		
		JavaUtility ju = new JavaUtility();
		String fname = fu.getExceldata("CreateContact", 1, 0);
		String FirstName=fname+ju.randomNumber();
		driver.findElement(By.name("firstname")).sendKeys(FirstName);
		
		String Lname = fu.getExceldata("CreateContact", 1, 1);
		String LastName=Lname+ju.randomNumber();
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		 
		//String title = driver.getTitle();
		
		wu.getWindows(driver);
		String Orgname = fu.getExceldata("CreateContact", 1, 2);
		driver.findElement(By.id("search_txt")).sendKeys(Orgname);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[.='"+Orgname+"']")).click();
		wu.getWindows(driver);
		
		String MobileNo = fu.getExceldata("CreateContact", 1, 3);
		driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys(MobileNo);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		driver.quit();
	}
}
