package com.ca.test.stepDefinations;

import com.ca.framework.base.Base;
import com.ca.framework.base.DriverContext;
import com.ca.framework.utilities.CucumberUtil;
import com.ca.framework.utilities.ExcelUtil;
import com.ca.test.pages.DashBoardPage;
import com.ca.test.pages.DefaultPage;
//import cucumber.api.PendingException;
import com.ca.test.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LoginSteps extends Base{

    @Given("^I am on the default homepage$")
    public void IAmOnTheDefaultHomepage() throws Throwable
    {
        DriverContext.WaitForPageToLoad();
        CurrentPage = GetInstance(DefaultPage.class);
        CurrentPage.As(DefaultPage.class).AcceptCookie();
        CurrentPage.As(DefaultPage.class).UserIsOnDefaultPage();
        CurrentPage = GetInstance(DefaultPage.class);
    }

    @When("^I click sign in button$")
    public void IClickSignInButton() throws Throwable
    {
        CurrentPage = GetInstance(DefaultPage.class);
        CurrentPage.As(DefaultPage.class).ClickSignin();
    }

    @When("^I insert UserName$")
    public void ILogInWithUsernameAndPassword() throws Throwable
    {
        //CurrentPage = GetInstance(LoginPage.class);
        //CurrentPage = CurrentPage.As(DefaultPage.class).ClickSignin();
        //CurrentPage.As(LoginPage.class).InsertUserName(ExcelUtil.ReadCell("UserName",1));
        //Thread.sleep(10000);
        //CurrentPage.As(LoginPage.class).NextBtn();
        //CurrentPage.As(LoginPage.class).InsertPassword(ExcelUtil.ReadCell("Password",1));
    }

    @And("I Login with credentials given in excel using {string} and RowNumber {int}")
    public void ILoginWithCredentialsGivenInExcelUsingAndRowNumber(String sheetName, Integer rowNumber) throws Throwable, InvalidFormatException, IOException
    {
        ExcelUtil reader = new ExcelUtil();
        List<Map<String,String>> testData =
                reader.getData("src/test/com/ca/test/TextData/Credentials.xlsx", sheetName);

        String username = testData.get(rowNumber).get("username");
        String password = testData.get(rowNumber).get("password");

        CurrentPage = GetInstance(LoginPage.class);
        CurrentPage.As(LoginPage.class).InsertUserName(username);
        CurrentPage.As(LoginPage.class).ClickNext();
        CurrentPage.As(LoginPage.class).InsertPassword(password);
        CurrentPage.As(LoginPage.class).ClickNext();
    }

    @And("I click Next button")
    public void IClickNextButton() throws Throwable
    {
        CurrentPage = GetInstance(LoginPage.class);
        CurrentPage.As(LoginPage.class).ClickNext();
    }

    @And("I insert UserName given in excel using {string} and RowNumber {int}")
    public void InsertUserNameGivenInExcelUsingAndRowNumber(String sheetName, Integer rowNumber) throws Throwable, InvalidFormatException, IOException
    {
        ExcelUtil reader = new ExcelUtil();
        List<Map<String,String>> testData =
                reader.getData("src/test/com/ca/test/TextData/Credentials.xlsx", sheetName);

        String username = testData.get(rowNumber).get("username");

        CurrentPage = GetInstance(LoginPage.class);
        CurrentPage.As(LoginPage.class).InsertUserName(username);
        CurrentPage.As(LoginPage.class).ClickNext();
    }

    @Then("I confirm error message")
    public void IConfirmErrorMessage() throws Throwable
    {
        Assert.assertEquals("Sorry, we don't recognise this email address.", "Sorry, we don't recognise this email address.", CurrentPage.As(LoginPage.class).getErrMsg());
    }

    @When("I navigate to calendar$")
    public void INavigateToCalendar() throws Throwable
    {
        CurrentPage = GetInstance(DashBoardPage.class);
        CurrentPage.As(DashBoardPage.class).GoToCalendar();
    }

    @Then("I confirm the current date$")
    public void IConfirmTheCurrentDate() throws Throwable
    {
        CurrentPage = GetInstance(DashBoardPage.class);
        Assert.assertEquals("8", "8", CurrentPage.As(DashBoardPage.class).GetDateByDay());
        Assert.assertEquals("Apr", "Apr", CurrentPage.As(DashBoardPage.class).GetDateByMth());
        Assert.assertEquals("8", "8", CurrentPage.As(DashBoardPage.class).GetDateByMth());
    }
}
