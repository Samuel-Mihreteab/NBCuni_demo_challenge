package com.sample.test.demo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaTypes;

public class DemoTest extends TestBase{

    @Test
    public void happypathTest() {
    	try {
    		Thread.sleep(2000);
    		WebElement pizza1=driver.findElement(By.id("pizza1Pizza"));
    		lib.dropDown(pizza1, 2);
    		lib.customWait(2);
    		WebElement top1=driver.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings1']"));
    		lib.dropDown(top1, 4);
    		lib.customWait(2);
    		WebElement top2=driver.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings2']"));
    		lib.dropDown(top2, 3);
    		lib.customWait(2);
    		
    		
    		
    		
    		
    		
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    	}
       
    }

}
