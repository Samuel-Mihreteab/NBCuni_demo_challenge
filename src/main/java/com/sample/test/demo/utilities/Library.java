package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Library {
	private WebDriver driver;
	
	public Library(WebDriver _driver) {
		driver = _driver;
	}
	public void dropDown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
		customWait(1);

	}
	public void dropDown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
		customWait(1);
	}
	public void customWait(double inSecs) {
		try {
			Thread.sleep((long) (inSecs * 1000));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
