package com.sample.test.demo;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Utilities.Library;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static Library lib;
    private Configuration config;
    public static WebDriver driver;
    protected String url;

    @BeforeClass(alwaysRun = true)
    public void init() throws Throwable {
    	lib = new Library(driver);
        config = new Configuration();
        url = config.getUrl();
        initializelDriver();
        navigateToSite();
    }

    private void navigateToSite() {
        driver.get(url);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        try {
            driver.quit();

        } catch (Exception e) {
        }
    }

    private void initializelDriver() {
        if (config.getBrowser().equalsIgnoreCase("chrome")) {
            if (config.getPlatform().equalsIgnoreCase("mac")) {
                //System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/mac/chromedriver");
            	
            	WebDriverManager.chromedriver().setup();
            	driver = new ChromeDriver();
            	driver.manage().deleteAllCookies();
            	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            	driver.manage().window().maximize();
            
            } else {
                //System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver/windows/chromedriver.exe");
            
            	WebDriverManager.chromedriver().setup();
            	driver = new ChromeDriver();
            	driver.manage().deleteAllCookies();
            	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            	driver.manage().window().maximize();
            }
            
        }
        else {
            fail("Unsupported bfrowser " + config.getBrowser());
        }
       
    }


}
