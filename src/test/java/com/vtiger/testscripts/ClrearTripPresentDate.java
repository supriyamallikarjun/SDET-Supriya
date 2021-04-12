package com.vtiger.testscripts;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ClrearTripPresentDate {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");
		driver.findElement(By.xpath("//input[@id='FromTag']")).sendKeys("BAN");
		driver.findElement(By.xpath("//a[contains(text(),'BLR')]")).click();
		driver.findElement(By.xpath("//input[@id='ToTag']")).sendKeys("PNQ");
		driver.findElement(By.xpath("//a[contains(text(),'PNQ')]")).click();
		driver.findElement(By.xpath("//input[@id='DepartDate']")).click();
		
		
		Date date=new Date();
		String currentDate = date.toString();
		String[] arr = currentDate.split("\s");
		String m = arr[1];
		String d = arr[2];
		String y = arr[5];
		
		//driver.findElement(By.xpath("//span[@class='ui-datepicker-month' and text()='"+m+"']")).click();
		//driver.findElement(By.xpath("//span[@class='ui-datepicker-year' and text()='"+y+"']")).click();
		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-active ']")).click();
		//driver.quit();
	}

}
