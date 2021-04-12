package com.vtiger.testscripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathForPython {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.selenium.dev/downloads/");
		List<WebElement> lNames = driver.findElements(By.xpath("//table[@class='data-list']//td[1]"));
		 List<WebElement> version = driver.findElements(By.xpath("//table[@class='data-list']//td[1]/../td[@data-label='Stable Version']"));
		for (int i = 0; i < lNames.size(); i++) {
			String text = lNames.get(i).getText();
			System.out.println(text);
			if(text.equals("Ruby")) {
				 String str = version.get(i).getText();
			System.out.println(text+" version is : "+ str);
			}
		}
		driver.quit();
	}

}
