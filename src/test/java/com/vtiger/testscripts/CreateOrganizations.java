package com.vtiger.testscripts;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CreateOrganizations {
		static {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		}
		public static void main(String[] args) {
			Random r = new Random();
			int rnumber = r.nextInt(1000);
			String orgname="TYSS"+rnumber;
			System.out.println(orgname);
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://localhost:8888/");
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
			driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("1234567890");
			WebElement indAdrs = driver.findElement(By.name("industry"));
			Select sel1 = new Select(indAdrs);
			sel1.selectByValue("Banking");
			WebElement accountAdrs = driver.findElement(By.name("accounttype"));
			Select sel2 = new Select(accountAdrs);
			sel2.selectByIndex(2);
			WebElement ratingAdrs = driver.findElement(By.name("rating"));
			Select sel3 = new Select(ratingAdrs);
			sel3.selectByValue("Active");
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			driver.navigate().refresh();
			driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
			driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgname);
			WebElement orgbox = driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']/select[@name='search_field']"));
			Select sel4 = new Select(orgbox);
			sel4.selectByVisibleText("Organization Name");
			driver.findElement(By.xpath("//input[@name='submit']")).click();
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Organizations' and text()='"+orgname+"']"))));
			String actualOrgName = driver.findElement(By.xpath("//a[@title='Organizations' and text()='"+orgname+"']")).getText();
			Assert.assertEquals(orgname,actualOrgName);
			System.out.println("Successfully found "+orgname);
			driver.quit();
	}

}
