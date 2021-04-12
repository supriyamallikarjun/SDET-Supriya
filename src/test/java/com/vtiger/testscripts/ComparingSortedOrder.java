package com.vtiger.testscripts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class ComparingSortedOrder {
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
		List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]/a[@title='Organizations']"));
		ArrayList<String> al = new ArrayList<String>();
		for (int i = 0; i < ele.size(); i++) {
			String text = ele.get(i).getText();
			//System.out.print(text);
			al.add(text);
		}
		System.out.println(al);
		Collections.sort(al);
		driver.findElement(By.xpath("//a[text()='Organization Name']")).click();
		List<WebElement> li = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]/a[@title='Organizations']"));
		ArrayList<String> al2 = new ArrayList<String>();
		for (int i = 0; i < li.size(); i++) {
			String text = li.get(i).getText();
			//System.out.print(text);
			al2.add(text);
		}
		System.out.println(al2);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(al, al2);
		driver.close();
		sa.assertAll();
	}

}
