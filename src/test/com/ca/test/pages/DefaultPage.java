package com.ca.test.pages;

import com.ca.framework.base.BasePage;
import com.ca.framework.base.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DefaultPage extends BasePage {
    public DefaultPage() {
        }

    @FindBy(how = How.CLASS_NAME, using = "_yb_1j5xf")
    public WebElement SigninBtn;

    @FindBy(how = How.ID, using = "ybar-logo")
    public WebElement YahooLogo;

    @FindBy(how = How.NAME, using = "agree")
    public WebElement AcceptAll;

    public void AcceptCookie()
    {
        AcceptAll.click();
        DriverContext.WaitForPageToLoad();
    }

    public boolean UserIsOnDefaultPage()
    {
        DriverContext.WaitForPageToLoad();
        return YahooLogo.isDisplayed();
    }

    public void ClickSignin()
    {
        DriverContext.WaitForPageToLoad();
        DriverContext.WaitForElementVisible(SigninBtn);
        SigninBtn.click();
    }
}
