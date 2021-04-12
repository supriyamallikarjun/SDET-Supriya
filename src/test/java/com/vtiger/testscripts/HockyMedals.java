package com.vtiger.testscripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HockyMedals {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.olympic.org/hockey/12-team-tournament-men");
		List<WebElement> names = driver.findElements(By.xpath("//ul[@class='related-list col6']//strong[@class='name']"));
		List<WebElement> numofmedals = driver.findElements(By.xpath("//ul[@class='related-list col6']//strong[@class='name']/ancestor::div[@class='holder']/ul/li/div[@class='medal']/span"));
		System.out.println("Names with medals of top 6 winners");
		System.out.println("------------------------------------");
		for (int i = 0; i < names.size() && i<numofmedals.size(); i++) {
			String name = names.get(i).getText();
			String medals=numofmedals.get(i).getText();
			System.out.println(name+" ----> "+medals);
		}
		driver.close();
	
	}
}
