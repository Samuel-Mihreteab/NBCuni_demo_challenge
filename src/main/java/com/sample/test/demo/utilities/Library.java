package com.sample.test.demo.utilities;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Library {
	final static Logger logger = Logger.getLogger(Library.class);
	private WebDriver driver;
	
	public Library(WebDriver _driver) {
		driver = _driver;
	}
	public void dropDown(WebElement element, int index) {
		
		Select sel = new Select(element);
		sel.selectByIndex(index);
		customWait(1);

	}
	
	
	public void dropDown(WebElement element, String visible) {
		
		Select sel = new Select(element);
		sel.selectByVisibleText(visible);
		customWait(1);

	}
	public void dropDown(WebElement element, String value,int sec) {
		
		Select sel = new Select(element);
		sel.selectByValue(value);
		customWait(sec);
	}
	public void customWait(double inSecs) {
		try {
			Thread.sleep((long) (inSecs * 1000));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	public void entertext(WebElement element, String inputtext) {
		
		try {
	
			element.click();
			element.clear();
			element.sendKeys(inputtext);
	
		}catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}

	}
	
	public void click(WebElement click) {
		try {
			
			click.click();
			
		}catch (Exception e) {
		e.printStackTrace();
		assertTrue(false);
		}
		
	}
	
	public void scrollToElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}
	
	public void scrollUpDown(int pixels) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("scroll(0," + pixels + ")");
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}
	
	public void javascriptClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}

}
