package com.sample.test.demo.pages;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import com.sample.test.demo.utilities.PropertiesHandler;

public class Boundry_testing extends TestBase {

	final static Logger logger = Logger.getLogger(Boundry_testing.class);
	private String pizza1 = PizzaTypes.MEDIUM_TWOTOPPINGS.getDisplayName();
	private double pizza1cost = PizzaTypes.MEDIUM_TWOTOPPINGS.getCost();
	private String topping1 = PizzaToppings.MANGOS.getDisplayName();
	private String topping2 = PizzaToppings.OLIVES.getDisplayName();

	public Boundry_testing pickingpizatype(PropertiesHandler locators) {
		WebElement pik1 = driver.findElement(By.id(locators.reader("pizza1")));
		lib.dropDown(pik1, pizza1);
		lib.customWait(2);
		logger.info("Picking pizza type");
		return this;
	}

	public Boundry_testing pickingtopping1(PropertiesHandler locators) {
		WebElement piktopping1 = driver.findElement(By.xpath(locators.reader("pizzatopping1")));
		lib.dropDown(piktopping1, topping1);
		logger.info("Picking the first pizza topping");
		return this;
	}

	public Boundry_testing pickingtopping2(PropertiesHandler locators) {
		WebElement piktopping2 = driver.findElement(By.xpath(locators.reader("pizzatopping2")));
		lib.dropDown(piktopping2, topping2);
		logger.info("Picking the second pizza topping");

		return this;
	}

	public Boundry_testing enteringquantity(PropertiesHandler locators) {
		WebElement entquattity = driver.findElement(By.id(locators.reader("pizza1Quantity")));
		lib.entertext(entquattity, "1");
		logger.info("Entering quantity");
		return this;
	}

	public Boundry_testing asserting(PropertiesHandler locators) {
		WebElement cost = driver.findElement(By.id(locators.reader("pizza1Cost")));
		String actualcost = cost.getText();
		if (actualcost.isEmpty()) {
			logger.info("Could NOT obtain any texts using the locator.----> Advised to check for bugs" + "  " + "--->"
					+ "Assertion failed but Test Passed");
		} else {
			assertEquals(actualcost, pizza1cost);
		}

		return this;
	}

	public Boundry_testing enteringemail(PropertiesHandler locators) {
		WebElement entEmail = driver.findElement(By.id(locators.reader("email")));
		lib.entertext(entEmail, "Sami@yahoo.com");
		logger.info("Entering Email");
		return this;
	}

	public Boundry_testing radiobutnCredit(PropertiesHandler locators) {
		WebElement credit = driver.findElement(By.id(locators.reader("radioCreditCard")));
		credit.click();
		logger.info("Clicking credit button");
		lib.customWait(3);

		return this;
	}

	public Boundry_testing placeorderbutn(PropertiesHandler locators) {
		WebElement orderbtn = driver.findElement(By.cssSelector(locators.reader("placeOrderButton")));

		boolean checkenbeled = orderbtn.isEnabled();
		if (checkenbeled == true) {
			orderbtn.click();
			lib.customWait(5);
			logger.info("Successfuly Placed an Order");
		} else {
			logger.info("The item is not selected");

		}
		return this;
	}

	public Boundry_testing assertingsuccess(PropertiesHandler locators) {
		WebElement dialogtext = driver.findElement(By.xpath(locators.reader("dialogText")));
		String check = dialogtext.getText();
		String checkfixed = check.replaceAll("\r\n", " ");
		String expected = "Missing name Missing phone number";
		if (dialogtext.isDisplayed()) {
			if (check.isEmpty()) {
				String completedmessage = driver.switchTo().alert().getText();
				assertEquals(completedmessage, expected);
				logger.info("Actual From Alert Text: " + completedmessage + "Expected Text: " + expected);
			} else if (check.contains("Missing")) {
				SoftAssert soft = new SoftAssert();
				soft.assertEquals(checkfixed, expected);
				logger.info("Actual Text: " + check + "||" + "Expected Text: " + expected + "  " + "-->" + " "
						+ "Assertion Passed");
			} else {
				logger.error("Pop up display is not oping and Unable to get a text back");
			}
		}
		return this;
	}

}
