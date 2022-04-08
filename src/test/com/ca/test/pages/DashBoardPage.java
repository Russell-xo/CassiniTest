package com.ca.test.pages;

import com.ca.framework.base.BasePage;
import com.ca.framework.base.DriverContext;
import com.ca.framework.config.Settings;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashBoardPage extends BasePage{

    public DashBoardPage(){

    }

    @FindBy(how = How.ID, using = "root_7")
    public WebElement FinanceTab;

    @FindBy(how = How.CLASS_NAME, using = "nr-applet-nav-item")
    public WebElement MarketDataTab;

    @FindBy(how = How.LINK_TEXT, using = "Calender")
    public WebElement CalenderDropdown;

    @FindBy(how = How.XPATH, using = "//span[text()='Apr']")
    public WebElement ConfirmApr;

    @FindBy(how = How.XPATH, using = "//span[text()='8']")
    public WebElement Confirm8;

    @FindBy(how = How.XPATH, using = "//span[text()='Fri']")
    public WebElement ConfirmFri;

    public void ClickFinanceTab()
    {
        DriverContext.WaitForPageToLoad();
        DriverContext.WaitForElementVisible(FinanceTab);
        FinanceTab.click();
    }

    public void ClickMarketDataTab()
    {
        Actions actions = new Actions(DriverContext.Driver);
        actions.moveToElement(MarketDataTab);
        actions.moveToElement(CalenderDropdown);
        actions.click().build().perform();
    }

    public void ClickCalenderDropdown()
    {
        DriverContext.WaitForElementVisible(CalenderDropdown);
        CalenderDropdown.click();
    }

    public void GoToCalendar()
    {
        DriverContext.WaitForPageToLoad();
        DriverContext.Driver.navigate().to("https://uk.finance.yahoo.com/calendar/");
        //DriverContext.Browser.GoToUrl("https://uk.finance.yahoo.com/calendar/");
    }

    public String GetDateByDay()
    {
        DriverContext.WaitForPageToLoad();
        DriverContext.WaitForElementVisible(Confirm8);
        return Confirm8.getText();
    }

    public String GetDateByMth()
    {
        DriverContext.WaitForElementVisible(ConfirmApr);
        return ConfirmApr.getText();
    }

    public String GetDateByDayOfWeek()
    {
        DriverContext.WaitForElementVisible(ConfirmFri);
        return ConfirmFri.getText();
    }

}
