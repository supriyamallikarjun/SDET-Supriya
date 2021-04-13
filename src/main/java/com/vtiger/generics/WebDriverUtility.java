package com.vtiger.generics;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void selectTheElement(WebElement ele, String value ) {
		Select select = new Select(ele);
		select.selectByValue(value);		
	}
	public void selectTheElement(String text, WebElement ele ) {
		Select select = new Select(ele);
		select.selectByValue(text);		
	}
	public void selectTheElement(WebElement ele, int index ) {
		Select select = new Select(ele);
		select.selectByIndex(index);		
	}
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(IConstant.implicitWaitTime, TimeUnit.SECONDS);
	}
	public void explicitWait(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, IConstant.explictWaitTime);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void elementToBeClickable(WebElement element) {
		int count=0;
		while(count<40) {
			try {
				element.isDisplayed();
				break;
			}
			catch(Exception e) {
				count++;
			}
		}
	}
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void getWindows(WebDriver driver,String title ) {
		
		Set<String> wnds = driver.getWindowHandles();
		for (String str : wnds) {
			if((str.equals(title))) {
				driver.switchTo().window(str);
			}
		}
	}
}




