package com.ca.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Initializer extends Base {

    public void InitializeBrowser(BrowserType browserType)
    {
        WebDriver driver = null;
        switch (browserType)
        {
            case Chrome:
            {
                System.setProperty("webdriver.chrome.driver", "src/com/ca/framework/drivers/chromedriver.exe");
                driver  = new ChromeDriver();
                break;
            }
            case Firefox:
            {
                System.setProperty("webdriver.gecko.driver", "src/com/ca/framework/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            }
            case IE:
            {
                break;
            }
        }
        //set driver
        DriverContext.setDriver(driver);
        //browser
        DriverContext.Browser = new Browser(driver);
    }
}
