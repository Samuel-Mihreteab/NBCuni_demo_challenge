package com.sample.test.demo.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.sample.test.demo.TestBase;
import com.sample.test.demo.pages.Boundry_testing;
import com.sample.test.demo.pages.Happy_Path;
import com.sample.test.demo.pages.Negative_testing;
import com.sample.test.demo.utilities.PropertiesHandler;

public class DemoTest extends TestBase {
	PropertiesHandler locators = new PropertiesHandler("src/test/resources/Locators/locators.properties");
	final static Logger logger = Logger.getLogger(DemoTest.class);

	@Test(priority = 1)
	public void happypathTest() {
		logger.info("Test Case 1: Making sure the order is successful.");
		Happy_Path happy = new Happy_Path();
		happy.pickingpizatype(locators);
		happy.pickingtopping1(locators);
		happy.pickingtopping2(locators);
		happy.enteringquantity(locators);
		happy.asserting(locators);
		happy.enteringname(locators);
		happy.enteringemail(locators);
		happy.enteringphone(locators);
		happy.radiobutnCredit(locators);
		happy.placeorderbutn(locators);
		happy.assertingsuccess(locators);   

	}

	@Test(priority = 2)
	public void negativetest() {
		logger.info("Test case 2: picking No topping pizza and picking 2 toppings on purpose ");
		Negative_testing negative = new Negative_testing();
		negative.pickingpizatype(locators);
		negative.pickingtopping1(locators);
		negative.pickingtopping2(locators);
		negative.enteringquantity(locators);
		negative.asserting(locators);
		negative.enteringname(locators);
		negative.enteringemail(locators);
		negative.enteringphone(locators);
		negative.radiobutnCredit(locators);
		negative.placeorderbutn(locators);
		negative.assertingsuccess(locators);

	}

	@Test(priority = 3)
	public void boundrytesting() {
		logger.info("Test case 3: Not entering Name and Phone number on purpose. As they are critical inorder to succesfully place an order");
		Boundry_testing bdt = new Boundry_testing();
		bdt.pickingpizatype(locators);
		bdt.pickingtopping1(locators);
		bdt.pickingtopping2(locators);
		bdt.enteringquantity(locators);
		bdt.asserting(locators);
		bdt.enteringemail(locators);
		bdt.radiobutnCredit(locators);
		bdt.placeorderbutn(locators);
		bdt.assertingsuccess(locators);

	}

}
