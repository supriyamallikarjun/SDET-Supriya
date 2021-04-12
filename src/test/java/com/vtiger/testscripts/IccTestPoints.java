package com.vtiger.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccTestPoints {
		static {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		}
		public static void main(String[] args) {
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.wikipedia.org/");
			driver.findElement(By.id("searchInput")).sendKeys("Icc Test Championship");
			driver.findElement(By.xpath("//i[text()='Search']")).click();
			WebElement ponints = driver.findElement(By.xpath("//td[@style='text-align:left']//a[@href='/wiki/India_national_cricket_team']/ancestor::tr/td[3]"));
			String p = ponints.getText();
			System.out.println("India's points are : "+p);
			driver.close();
		}

}
