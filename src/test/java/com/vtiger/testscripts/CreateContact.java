package com.vtiger.testscripts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class CreateContact {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		WebElement adrs = driver.findElement(By.name("salutationtype"));
		Select s1=new Select(adrs);
		s1.selectByValue("Ms.");
		driver.findElement(By.name("firstname")).sendKeys("Saanchi");
		driver.findElement(By.name("lastname")).sendKeys("D");
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		 String pwnd = driver.getWindowHandle();
		Set<String> cwnd = driver.getWindowHandles();
		for (String string : cwnd) {
			if(!(string.equals(pwnd))) {
			driver.switchTo().window(string);
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys("PY_Product");
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[.='PY_Product']")).click();
		driver.switchTo().window(pwnd);
		driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("123456");
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		driver.quit();
	}
}
