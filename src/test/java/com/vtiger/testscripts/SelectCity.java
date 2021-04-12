package com.vtiger.testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SelectCity extends DataProvider {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@Test
	public void selectCity(String src, String dest) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");
		driver.findElement(By.xpath("//input[@id='FromTag']")).sendKeys(src);
		driver.findElement(By.xpath("//a[contains(text(),'"+src+"')]")).click();
		driver.findElement(By.xpath("//input[@id='ToTag']")).sendKeys(dest);
		driver.findElement(By.xpath("//a[contains(text(),'"+dest+"')]")).click();
		driver.findElement(By.xpath("//input[@id='DepartDate']")).click();
		int i=0;
		while(i<11) {
			try {
			driver.findElement(By.xpath("(//tbody/tr[2]/td[@data-month='8'])[1]/a")).click();
			break;
			}
			catch (Exception e) {
				driver.findElement(By.xpath("//a[@title='Next' and @class='nextMonth ']")).click();
				i++;
			}
		}
		System.out.println(i);
		driver.close();
	
	}
}
