package com.vtiger.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectAOrgAndDelete {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]/a[text()='PY_Product']/../../td[1]")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]/a[text()='PY_Product']/../../td[1]/../td[8]/a[2]")).click();
		driver.switchTo().alert().accept();
		driver.quit();

	}

}
