package com.ca.test.pages;

import com.ca.framework.base.BasePage;
import com.ca.framework.base.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    public LoginPage(){

    }

    @FindBy(how = How.ID, using = "login-username")
    public WebElement UserNameTxtBox;

    @FindBy(how = How.NAME, using = "password")
    public WebElement PasswordTxtBox;

    @FindBy(how = How.ID, using = "login-signin")
    public WebElement NextBtn;

    @FindBy(how = How.ID, using = "username-error")
    public WebElement ErrMsg;

    public void ClickNext()
    {
        DriverContext.WaitForPageToLoad();
        DriverContext.WaitForElementVisible(NextBtn);
        NextBtn.click();
    }

    public void InsertUserName(String userName)
    {
        DriverContext.WaitForPageToLoad();
        UserNameTxtBox.sendKeys(userName);
    }

    public void InsertPassword(String password)
    {
        DriverContext.WaitForPageToLoad();
        DriverContext.WaitForElementVisible(PasswordTxtBox);
        PasswordTxtBox.sendKeys(password);
    }

    public String getErrMsg()
    {
        DriverContext.WaitForElementVisible(ErrMsg);
        return ErrMsg.getText();
    }

    public boolean IsErrMsgDisplayed()
    {
        return ErrMsg.isDisplayed();
    }
}
