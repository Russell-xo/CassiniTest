/*
package com.ca.test.stepDefinations;

import com.ca.framework.base.DriverContext;
import com.ca.framework.base.Initializer;
import com.ca.framework.utilities.ExcelUtil;
import com.ca.test.hooks.TestInitializer;
import com.ca.test.pages.DefaultPage;
import com.ca.test.pages.LoginPage;
import org.junit.Test;

public class LoginTest extends TestInitializer {

    @Test
    public void Login() throws InterruptedException
    {
        DriverContext.WaitForPageToLoad();
        CurrentPage = GetInstance(DefaultPage.class);
        CurrentPage.As(DefaultPage.class).AcceptCookie();
        Thread.sleep(5000);
        CurrentPage.As(DefaultPage.class).UserIsOnDefaultPage();
        CurrentPage = GetInstance(DefaultPage.class);
        CurrentPage.As(DefaultPage.class).ClickSignin();

        CurrentPage = GetInstance(LoginPage.class);
        Thread.sleep(10000);
        CurrentPage.As(LoginPage.class).InsertUserName(ExcelUtil.ReadCell("UserName",1));
        Thread.sleep(10000);
        //CurrentPage.As(LoginPage.class).NextBtn();
        CurrentPage.As(LoginPage.class).InsertPassword(ExcelUtil.ReadCell("Password",1));
    }
}
*/
